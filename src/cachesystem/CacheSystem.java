package cachesystem;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

// --- 1. Storage & Eviction Contracts (Unchanged) ---
interface CacheStorage<K, V> {
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    int size();
}

interface DBStorage<K, V> {
    V get(K key);
    void put(K key, V value);
}

interface CacheEvictPolicy<K> {
    void keyAccessed(K key);
    K evictKey();
}

// --- 2. The Strategy Pattern for Write Policies ---
interface CacheWritePolicy<K, V> {
    // The policy dictates exactly how the write happens across cache and DB
    void write(K key, V value, CacheStorage<K, V> cache, DBStorage<K, V> db);
}

// Concrete Strategy: Write Through (Synchronous)
class WriteThroughPolicy<K, V> implements CacheWritePolicy<K, V> {
    @Override
    public void write(K key, V value, CacheStorage<K, V> cache, DBStorage<K, V> db) {
        db.put(key, value); // Write to DB first
    }
}

// Concrete Strategy: Write Back (Asynchronous)
class WriteBackPolicy<K, V> implements CacheWritePolicy<K, V> {
    private final ExecutorService asyncExecutor = Executors.newFixedThreadPool(4);

    @Override
    public void write(K key, V value, CacheStorage<K, V> cache, DBStorage<K, V> db) {
        asyncExecutor.submit(() -> db.put(key, value)); // Background sync to DB
    }
}

// --- 3. The Core Cache System (Using Lock Striping) ---
public class CacheSystem<K, V> {
    private final CacheStorage<K, V> cacheStorage;
    private final DBStorage<K, V> dbStorage;
    private final CacheEvictPolicy<K> evictPolicy;
    private final CacheWritePolicy<K, V> writePolicy;
    private final int capacity;

    // Lock Striping: Array of locks to reduce contention
//    private final ReentrantLock[] locks;
//    private static final int STRIPE_COUNT = 16; // Standard default

    public CacheSystem(CacheStorage<K, V> cacheStorage, DBStorage<K, V> dbStorage,
                       CacheEvictPolicy<K> evictPolicy, CacheWritePolicy<K, V> writePolicy, int capacity) {
        this.cacheStorage = cacheStorage;
        this.dbStorage = dbStorage;
        this.evictPolicy = evictPolicy;
        this.writePolicy = writePolicy;
        this.capacity = capacity;

//        this.locks = new ReentrantLock[STRIPE_COUNT];
//        for (int i = 0; i < STRIPE_COUNT; i++) {
//            locks[i] = new ReentrantLock();
//        }
    }

    // Helper to get the specific lock for a key
//    private ReentrantLock getLockForKey(K key) {
//        int hash = Math.abs(key.hashCode() % STRIPE_COUNT);
//        return locks[hash];
//    }

    public V get(K key) {
        V value = cacheStorage.get(key);
        if(value == null) {
            value = dbStorage.get(key);
            manageEvictionAndInsert(key, value);
            cacheStorage.put(key, value);
        }
        return value;
    }

    public void put(K key, V value) {
//        ReentrantLock lock = getLockForKey(key);
//        lock.lock();
        try {
            // Delegate the entire orchestration to the injected Strategy
            manageEvictionAndInsert(key, value);
            cacheStorage.put(key, value);
            writePolicy.write(key, value, cacheStorage, dbStorage);
        } finally {
//            lock.unlock();
        }
    }

    // Static helper shared by write policies to keep eviction atomic with insertion
    void manageEvictionAndInsert(K key, V value) {
        if (cacheStorage.size() >= capacity && cacheStorage.get(key) == null) {
            K keyToEvict = evictPolicy.evictKey();
            if (keyToEvict != null) {
                cacheStorage.remove(keyToEvict);
            }
        }
        cacheStorage.put(key, value);
        evictPolicy.keyAccessed(key);
    }
}
