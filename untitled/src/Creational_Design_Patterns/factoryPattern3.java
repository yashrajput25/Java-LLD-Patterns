package Creational_Design_Patterns;


interface Notification{
    public void send();
}

class EmailNotification implements Notification{

    public void send(){
        System.out.println("Sending email");
    }
}

class SMSNotification implements Notification{

    public void send(){
        System.out.println("Sending message");
    }

}

class NotificationFactory{

    public static Notification getNotification(String mode){
        if(mode.equalsIgnoreCase("SMS")){
            return new SMSNotification();
        }else if(mode.equalsIgnoreCase("email")){
            return new EmailNotification();
        }

        return null;
    }
}



class NotificationService {
    public void notifyUser(String type) {
        Notification notification = NotificationFactory.getNotification(type);
        notification.send();
    }
}


public class factoryPattern3 {

    public static void main(String[] args){
        NotificationService notificationService = new NotificationService();
        notificationService.notifyUser("SMS");
    }


}
