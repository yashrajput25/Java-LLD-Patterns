package StructuralDesignPatterns;

interface Coffee{
    public double getCost();
    public String getDescription();
}

class SimpleCoffee implements Coffee{

    private int cost;

    @Override
    public double getCost() {
        return 50;
    }

    @Override
    public String getDescription() {
       return "Simple Coffee";
    }
}


abstract class CoffeeDecorator implements Coffee{

    Coffee coffee;

    CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}

class MilkDecorator extends CoffeeDecorator{

    MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator{

    SugarDecorator(Coffee coffee){
        super(coffee);
    }

    public String getDescription(){
        return super.getDescription() + " + Sugar";
    }

    public double getCost(){
        return  super.getCost() + 10;
    }
}

class CreamDecorator extends CoffeeDecorator{

    CreamDecorator(Coffee coffee){
        super(coffee);
    }


    @Override
    public double getCost() {
        return super.getCost() + 15;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Cream";
    }
}

public class decoratorPattern1 {

    public static void main(String[] args){
        //chaining
        Coffee coffee = new CreamDecorator(
                new MilkDecorator(
                        new SugarDecorator(
                                new SimpleCoffee())));

        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());

    }

}
