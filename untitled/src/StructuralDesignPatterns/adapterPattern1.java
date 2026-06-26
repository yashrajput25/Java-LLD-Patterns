package StructuralDesignPatterns;

interface Thermometer{
    public double getTemperature();
}

class CelsiusSensor implements Thermometer{

    public double getTemperature(){
        return 25.0;
    }
}

//different class
class FahrenheitSensor {
    public double readFahrenheit(){
        return 98.6;
    }
}

//adapter pattern
class FahrenheitAdapter implements Thermometer{

    private FahrenheitSensor sensor;
    public FahrenheitAdapter(){
        sensor = new FahrenheitSensor();
    }

    public double getTemperature(){
        double F = sensor.readFahrenheit();
        return (F-32)*5/9;
    }
}


public class adapterPattern1 {
    public static void main(String[] args){
        FahrenheitAdapter adapter = new FahrenheitAdapter();
        System.out.println(adapter.getTemperature());
    }
}
