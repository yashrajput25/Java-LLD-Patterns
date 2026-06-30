package StructuralDesignPatterns;

interface PaymentGateway{
    public void processPayment(double amount);
}

class PayUGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing via PayU, amount: "+amount);
    }
}

class StripeAdapter implements PaymentGateway{
    StripeAPI gateway;
    public StripeAdapter(){
        gateway = new StripeAPI();
    }

    public void processPayment(double amount){
        gateway.process(amount);
    }
}


//incompatible
class StripeAPI {
    void process(double price) {
        System.out.println("Processing payment via StripeAPI, " +
                "amount: "+price);
    }
}


class PaymentService{
    PaymentGateway gateway;
    PaymentService(PaymentGateway gateway){
        this.gateway = gateway;
    }

    void process(int amount){
        gateway.processPayment(amount);
    }
}


public class adapterPattern3 {

    public static void main(String[] args){
        PaymentService app = new PaymentService(new StripeAdapter());
        app.process(5000);
    }
}
