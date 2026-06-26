package Creational_Design_Patterns;

interface Logistics{
    public void send();
}

class Truck implements Logistics{
    public void send(){
        System.out.println("Sending via truck");
    }
}

class Ship implements Logistics {
    public void send(){
        System.out.println("Sending via Ship");
    }
}



class LogisticsFactory{

    public static Logistics getLogisitics(String mode){
        if(mode.equalsIgnoreCase("truck")){
            return new Truck();
        }else if(mode.equalsIgnoreCase("ship")){
            return new Ship();
        }

        return null;
    }
}


//client code
class LogisticsApplication{

    void processOrder(String mode){
        Logistics logistics = LogisticsFactory.getLogisitics(mode);
        logistics.send();
    }
}


public class factory1
{
    public static void main(String[] args){
        LogisticsApplication app = new LogisticsApplication();
        app.processOrder("ship");
    }
}