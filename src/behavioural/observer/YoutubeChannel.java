package behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {

    List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber sub) {
        subscribers.add(sub);
    }

    public void uploadVideo(String video) {
        //handle upload video
        notifySubscribers();
    }

    public boolean notifySubscribers() {
        try {
            for (Subscriber sub : subscribers) {
                sub.update("");
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
