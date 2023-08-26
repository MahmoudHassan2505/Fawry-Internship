package Actuators;

public class Alarm {

    private String alarmName;

    public Alarm(String alarmName){
        this.alarmName = alarmName;
    }
    public void turnOn(){
        System.out.println(alarmName+" :Motion Detected !!!!!!("+alarmName+")");
    }

    public void turnOff(){
        System.out.println(alarmName+" :Alarm is turned Off");
    }
}
