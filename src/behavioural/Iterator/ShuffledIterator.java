package behavioural.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledIterator<T> implements Iterator<T>{

    private final List<T> list;
    private Integer index;

    public ShuffledIterator(PlayList<T> playlist) {
        this.list = new ArrayList<>(playlist.items);
        Collections.shuffle(this.list);
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return ++index < list.size();
    }

    @Override
    public T next() {
        return list.get(index);
    }
}
