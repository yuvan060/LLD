package behavioural.Iterator;

import java.util.Iterator;

public class Main {

    public static <T> Iterator<T> iterate(IteratorType type, PlayList<T> playList) {
        switch (type) {
            case SHUFFLED -> new ShuffledIterator<>(playList);
            case FAVOURITE -> new FavouriteCollectionIterator<>(playList);
            default -> throw new IllegalArgumentException("No Iterator Found");
        }
        return null;
    }
    public static void main(String[] args) {
        PlayList<Song> songs = new PlayList<>();
        PlayList<Video> videoPlayList = new PlayList<>();

        Iterator<Song> shuffledSong = iterate(IteratorType.SHUFFLED, songs);
        Iterator<Video> videoIterator = iterate(IteratorType.FAVOURITE, videoPlayList);
    }
 }
