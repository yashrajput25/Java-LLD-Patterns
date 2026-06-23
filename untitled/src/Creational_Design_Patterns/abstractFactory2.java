package Creational_Design_Patterns;

interface Car{
    public void assemble();
}

class Sedan implements Car{

    public void assemble(){
        System.out.println("Assembling/Creating a Sedan");
    }
}

class Hatchback implements  Car{

    public void assemble(){
        System.out.println("Assembling/Creating a Hatchback");
    }
}


interface CarSpecifications{
    public void displaySpecifications();
}

class IndianCarSpecifications implements CarSpecifications{
    @Override
    public void displaySpecifications(){
        System.out.println("INDIAN RULES : cars are primarily designed for " +
                "extreme cost-efficiency, high fuel economy, and ruggedness " +
                "for diverse road conditions.");
    }
}


class EuropeanCarSpecification implements CarSpecifications{
    @Override
    public void displaySpecifications() {
        System.out.println("EUROPEAN RULES :  cars are built for strict environmental regulations, " +
                "higher-speed highway performance, and premium features.");
    }
}



interface CarFactory{
    public Car createCar(String carType);
    public CarSpecifications createCarSpecification();
}

class IndianCarFactory implements CarFactory
{
     public Car createCar(String carType){
         if(carType.equalsIgnoreCase("sedan")){
             return new Sedan();
         }else if(carType.equalsIgnoreCase("hatchback")){
             return new Hatchback();
         }
         return null;
    }

    public CarSpecifications createCarSpecification(){
        return new IndianCarSpecifications();
    }

}

class EuropeanCarFactory implements CarFactory{

    public Car createCar(String carType){
        if(carType.equalsIgnoreCase("sedan")){
            return new Sedan();
        }else if(carType.equalsIgnoreCase("hatchback")){
            return new Hatchback();
        }
        return null;
    }

    public CarSpecifications createCarSpecification(){
        return new EuropeanCarSpecification();
    }

}


//this should have abstraction, I cannot have specifics here such as indian or european
class CarService{
    private CarFactory factory;
    private String carType;

    public CarService(CarFactory factory, String carType){
        this.factory = factory;
        this.carType = carType;
    }

    public void getCar(){
        Car car = factory.createCar(carType);
        car.assemble();
    }

    public void getSpecifications(){
        CarSpecifications specifications = factory.createCarSpecification();
        specifications.displaySpecifications();
    }
}


public class abstractFactory2 {

    public static void main(String[] args){
        CarFactory factory = new IndianCarFactory();
        CarService service = new CarService(factory ,"sedan");
        service.getCar();
        service.getSpecifications();
    }
}
