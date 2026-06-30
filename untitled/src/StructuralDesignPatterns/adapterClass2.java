package StructuralDesignPatterns;

interface EmailService{
    public void send(String to, String message);
}

class EmailAdapter implements EmailService{

    ThirdPartyEmailAPI email;

    EmailAdapter(ThirdPartyEmailAPI email){
        this.email = email;
    }

    @Override
    public void send(String to, String message){
        email.sendMail(to, message);
    }

}


//incompatible class
class ThirdPartyEmailAPI {
    void sendMail(String recipient, String body) {
        System.out.println("Sending the message to: " + recipient);
        System.out.println(body);
    }
}



public class adapterClass2 {

    public static void main(String[] args){

        EmailService app = new EmailAdapter(new ThirdPartyEmailAPI());
        app.send("Yash", "ajksndacnjdfncvjn");

    }


}
