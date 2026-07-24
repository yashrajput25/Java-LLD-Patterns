package BehaviouralDesignPatterns;

interface PriceStrategy{
    public double totalPrice(double price);
}

class Christmas implements PriceStrategy{
    @Override
    public double totalPrice(double price) {
        double totalPrice = price - (price * 0.15);
        return totalPrice;
    }
}

class BlackFriday implements PriceStrategy{
    @Override
    public double totalPrice(double price) {
        double totalPrice = price - (price * 0.50);
        return totalPrice;
    }
}

class Diwali implements PriceStrategy{
    @Override
    public double totalPrice(double price) {
        double totalPrice = price - (price * 0.25);
        return totalPrice;
    }
}


class ShoppingService{

    private PriceStrategy strategy;
    private double price;

    public ShoppingService(PriceStrategy strategy, double price){
        this.strategy = strategy;
        this.price = price;
    }

    public void setStrategy(PriceStrategy strategy){
        this.strategy = strategy;
    }

    public double checkout(){
        return strategy.totalPrice(price);
    }

}

public class StrategyPattern2 {

    public static void main(String[] args){
        ShoppingService service = new ShoppingService(new BlackFriday(), 1000);
        System.out.println(service.checkout());
        service.setStrategy(new Diwali());
        System.out.println(service.checkout());
    }
}
