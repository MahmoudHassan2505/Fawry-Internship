package Sensor.Models;

import Actuators.Alarm;
import Data.Owner;
import Message.SMSImp;
import java.util.ArrayList;

public class BoschMotionSensor implements Sensor{

   private boolean isOn;
   ArrayList<Alarm> alarms;
   private Owner owner;

    public BoschMotionSensor() {
        alarms = new ArrayList<>();
    }


    @Override
    public void turnOn() {
        System.out.println("BOSCH Motion sensor turned on");
        this.isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("BOSCH Motion sensor turned off");
        sensorLog("BOSCH Motion sensor turned off");
        this.isOn =false;
    }

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

    public void removeAlarm(Alarm alarm){
        alarms.remove(alarm);
    }

    public void setOwner(Owner owner){
        this.owner = owner;
    }

    @Override
    public void alert() {
        if(this.isOn){
            System.out.println("alert(from Object) : Motion Detected");
            sensorLog("SensorAlert: Motion Detected");

            alarms.stream()
                    .forEach(alarm -> {
                        alarm.turnOn();
                        sensorLog("Turning "+alarm.getAlarmName()+" On");
                    });

            new SMSImp("Motion Detected",owner.getPhoneNumber()).send();

        }

    }

    public void alertsOff(){
        System.out.println("(from Object) : all alarms is off");

        alarms.stream()
                .forEach(alarm -> {
                    alarm.turnOff();
                    sensorLog("Turning "+alarm.getAlarmName()+" Off");});
    }
}
