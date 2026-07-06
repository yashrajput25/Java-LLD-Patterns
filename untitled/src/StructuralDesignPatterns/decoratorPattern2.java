package StructuralDesignPatterns;

interface Notification{
    public void send(String message);
    public double getCost();
}

// Base Class//
class EmailNotification implements Notification{

    public void send(String message){
        System.out.println("Sending Email with message: "+message);
    }

    public double getCost(){
        return 0.05;
    }
}

abstract class NotificationDecorator implements Notification{

    Notification notification;
    public NotificationDecorator(Notification notification){
        this.notification = notification;
    }

    public void send(String message){
        notification.send(message);
    }

    @Override
    public double getCost() {
        return notification.getCost();
    }
}


class SMSDecorator extends NotificationDecorator{

    SMSDecorator(Notification notification){
        super(notification);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending SMS with message: "+message);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.12;
    }
}

class SlackDecorator extends NotificationDecorator{

    SlackDecorator(Notification notification){
        super(notification);
    }

    @Override
    public void send(String message) {
        System.out.println("Sending Slack with message: "+message);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.20;
    }

}


public class decoratorPattern2 {

    public static void main(String[] args){

        NotificationDecorator app = new SlackDecorator(new SMSDecorator(new EmailNotification()));
        app.send("ABC");
        System.out.println(app.getCost());

    }

}
