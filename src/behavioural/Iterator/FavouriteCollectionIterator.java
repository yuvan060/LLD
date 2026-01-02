package behavioural.Iterator;

import java.util.ArrayList;
import java.util.List;

public class FavouriteCollectionIterator<T> implements Iterator<T>{
    private final List<T> list;
    private Integer index;

    public FavouriteCollectionIterator(PlayList<T> playList) {
        this.list = new ArrayList<>(playList.items);
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        while(index < list.size()) {
//            condition to check fav song
            //if condition is true return true;
            index++;
        }
        return false;
    }

    @Override
    public T next() {
        return list.get(index);
    }
}
