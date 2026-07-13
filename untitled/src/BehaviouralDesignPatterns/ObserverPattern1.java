package BehaviouralDesignPatterns;


import java.util.ArrayList;
import java.util.List;

interface Subject{
    public void addSubscriber(Observer subscriber);
    public void removeSubscriber(Observer subscriber);
    public void notifySubscribers(String title);
    public void uploadVideo(String title);
}


class YoutubeChannel implements Subject{

    private List<Observer> subscribers = new ArrayList<>();
    private String title;

    @Override
    public void addSubscriber(Observer subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Observer subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void uploadVideo(String title) {
        System.out.println("The video is uploaded on to the channel: "+title);
        notifySubscribers(title);
    }

    @Override
    public void notifySubscribers(String title) {

        for(Observer subscriber : subscribers){
            subscriber.notification(title);
        }
    }
}


interface Observer{
    public void subscribe(Subject channel);
    public void unsubscribe(Subject channel);
    public void notification(String title);

}

class Subscriber implements Observer{

    private String name;

    public Subscriber(String name){
        this.name = name;
    }

    public void subscribe(Subject channel){
        channel.addSubscriber(this);
    }

    public void unsubscribe(Subject channel){
        channel.removeSubscriber(this);
    }

    @Override
    public void notification(String title) {
        System.out.println("Subscriber "+this.name +
                " has received the notification for the video : "+title);
    }
}

public class ObserverPattern1 {

    public static void main(String[] args){

        // Create one YouTube channel
        YoutubeChannel channel = new YoutubeChannel();

        // Create 10 subscribers
        Subscriber s1 = new Subscriber("Alice");
        Subscriber s2 = new Subscriber("Bob");
        Subscriber s3 = new Subscriber("Charlie");
        Subscriber s4 = new Subscriber("David");
        Subscriber s5 = new Subscriber("Emma");
        Subscriber s6 = new Subscriber("Frank");
        Subscriber s7 = new Subscriber("Grace");
        Subscriber s8 = new Subscriber("Henry");
        Subscriber s9 = new Subscriber("Isabella");
        Subscriber s10 = new Subscriber("Jack");

        // Subscribe everyone to the channel
        s1.subscribe(channel);
        s2.subscribe(channel);
        s3.subscribe(channel);
        s4.subscribe(channel);
        s5.subscribe(channel);
        s6.subscribe(channel);
        s7.subscribe(channel);
        s8.subscribe(channel);
        s9.subscribe(channel);
        s10.subscribe(channel);

        // Upload a new video and notify subscribers
        String videoTitle = "Ghost Official Music Video -Justin Bieber";
        channel.uploadVideo(videoTitle);

    }
}
