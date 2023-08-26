package Actuators;

public class WaterSparkels implements Acuator{

    private String name;

    public WaterSparkels(String name){
        this.name = name;
    }
    public void turnOn(){
        System.out.println(name+" :Smoke Detected !!!!!!("+name+")");
    }

    public void turnOff(){
        System.out.println(name+" :WaterSparkles is turned Off");
    }
}
