package creational;

public class Singleton {
    //simple way to impl singleton is to use Eager Initialization
    // but the limitation is that we cannot handle exceptions & the object will be in memory whether it is used not used
    public static final Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Singleton class is initialized");
    }

    private static Singleton singletonInstance;
    //using static blocks we can handle exceptions, but the object lives in the memory even though it is not used
    static {
        try {
            singletonInstance = new Singleton();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static Singleton singletonInstanceConcurrent;
    private static Object lock = new Object();
    //we can do lazy initialization & but we need to handle concurrent edge cases
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (lock) {
                if(instance == null) {
                    singletonInstanceConcurrent = new Singleton();
                }
            }
        }
        return singletonInstanceConcurrent;
    }

    //easy way is to use static inner class, because that class will be loaded only when this static getInstance method is called
    public static class SingletonHolder {
        private static Singleton instance;
        public static Singleton getSingletonInstace(Object ...args) {
            if(instance == null) {
                instance = new Singleton();
            }
            return Singleton.instance;
        }
    }

    private static Singleton getSingletonInstance() {
        return SingletonHolder.getSingletonInstace();
    }
}
