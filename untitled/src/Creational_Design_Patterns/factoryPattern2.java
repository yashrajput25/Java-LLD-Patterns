package Creational_Design_Patterns;
/* **Coding Question:**

    Implement a Factory Pattern for a payment system:

    - Create an interface `PaymentGateway`.
    - Create two implementations: `RazorPay` and `PayU`.
    - Create a `PaymentFactory` that returns the appropriate implementation based on a string input.
    - Write client code that processes a payment without directly instantiating `RazorPay` or `PayU`.*/


interface PaymentGateway{
    public void processPayment();
}

class RazorPay implements PaymentGateway{
    public void processPayment(){
        System.out.println("Paying via RazorPay");
    }
}

class PayU implements PaymentGateway{
    public void processPayment(){
        System.out.println("Paying via PayU");
    }
}

class PaymentFactory {
    public static PaymentGateway getPaymentGateway(String gateway){
        if(gateway.equalsIgnoreCase("Razorpay")){
            return new RazorPay();
        }else if(gateway.equalsIgnoreCase("Payu")){
            return new PayU();
        }
        return null;
    }
}

class PaymentApplication{

    void processPayment(String gateway){
        PaymentGateway payment = PaymentFactory.getPaymentGateway(gateway);
        payment.processPayment();
    }

}



public class factoryPattern2 {
    public static void main(String args[]){
        PaymentApplication app = new PaymentApplication();
        app.processPayment("Razorpay");
    }
}
