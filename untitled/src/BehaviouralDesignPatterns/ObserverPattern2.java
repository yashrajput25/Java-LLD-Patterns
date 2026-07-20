package BehaviouralDesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface observer {
    public void update(double updatedTemp);

    public void display();
}

class MobileDisplay implements observer{

    private double temp;

    @Override
    public void display() {
        System.out.println("The mobile displays: "+ temp );
    }

    @Override
    public void update(double updatedTemp) {
        temp = updatedTemp;
    }
}

class TVDisplay implements observer{
    private double temp;

    public void update(double updatedTemp){
        temp = updatedTemp;
    }

    public void display(){
        System.out.println("The tv displays: "+temp);
    }

}


interface subject{
    public void registerObserver(observer observer);
    public void removeObserver(observer observer);
    public void notifyObservers();
    public void updateTemp(double temp);

}


class WeatherStation implements subject{

    double temp;
    private List<observer> observers;

    public WeatherStation(double temp){
        this.temp = temp;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(observer o : observers){
            o.update(temp);
        }
    }

    @Override
    public void updateTemp(double temp) {
        this.temp = temp;
        notifyObservers();
    }
}


public class ObserverPattern2 {

    public static void main(String[] args){

        observer mobile = new MobileDisplay();
        observer tv = new TVDisplay();

        subject weatherStation = new WeatherStation(20.5);

        weatherStation.registerObserver(mobile);
        weatherStation.registerObserver(tv);

        weatherStation.notifyObservers();

        mobile.display();
        tv.display();

        weatherStation.updateTemp(44.356);
        mobile.display();
        tv.display();

    }

}
