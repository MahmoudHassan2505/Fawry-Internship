package Sensor.Models;

import Actuators.Alarm;
import Data.Owner;
import Message.SMSImp;
import java.util.ArrayList;

public class BoschMotionSensor implements Sensor{

   private boolean isOn;
   private static BoschMotionSensor obj;
   ArrayList<Alarm> alarms;
   private Owner owner;

    private BoschMotionSensor() {
        alarms = new ArrayList<>();
    }

    public static BoschMotionSensor getInstance()
    {
        if (obj == null)
        {
            synchronized (BoschMotionSensor.class)
            {
                if (obj==null)
                    obj = new BoschMotionSensor();
            }
        }
        return obj;
    }
    @Override
    public void turnOn() {
        System.out.println("BOSCH Motion sensor turned on");
        obj.isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("BOSCH Motion sensor turned off");
        obj.isOn =false;
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
        if(obj.isOn){
            System.out.println("alert(from Object) : Motion Detected");

            alarms.stream()
                    .forEach(alarm -> alarm.turnOn());

            new SMSImp("Motion Detected",owner.getPhoneNumber()).send();

        }

    }

    public void alertsOff(){
        System.out.println("(from Object) : all alarms is off");

        alarms.stream()
                .forEach(alarm -> alarm.turnOff());
    }
}
