package BehaviouralDesignPatterns;

interface PaymentStrategy{

    public boolean validateDetails();
    public void pay(double amount);
}

//concrete strategies
class CreditCard implements PaymentStrategy{

    private String name;
    private int cardNumber, cvv;

    public CreditCard(String name, int cardNumber, int cvv){
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
    }


    @Override
    public boolean validateDetails() {
        return true;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid via credit card: "+amount);
    }
}

class PayPal implements PaymentStrategy{
    private String email, password;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean validateDetails() {
        return true;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid via paypal: "+amount);
    }

}

class Bitcoin implements PaymentStrategy{

    private String walletAddress;

    public Bitcoin(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public boolean validateDetails() {
        return true;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid via bitcoin: "+amount);
    }

}


class PaymentContext{
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount){
        if(paymentStrategy!=null){
            if(paymentStrategy.validateDetails()){
                paymentStrategy.pay(amount);
            }else{
                System.out.println("Error invalid details");
            }

        }
    }

}

public class StrategyPattern1 {

    public static void main(String[] args){
        PaymentContext paymentContext = new PaymentContext(new CreditCard("Yash", 12345678, 933));
        paymentContext.processPayment(10000);
        paymentContext.setPaymentStrategy(new PayPal("yash@gmail.com" , "abcdef"));
        paymentContext.processPayment(10000);

    }
}
