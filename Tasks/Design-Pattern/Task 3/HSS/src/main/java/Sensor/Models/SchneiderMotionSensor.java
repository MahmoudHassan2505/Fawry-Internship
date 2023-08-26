package Sensor.Models;

import Actuators.Alarm;
import Data.Owner;
import Message.SMSImp;

import java.util.ArrayList;

public class SchneiderMotionSensor implements Sensor{

    private boolean isOn;
    private static SchneiderMotionSensor obj;
    ArrayList<Alarm> alarms;

    private Owner owner;


    private SchneiderMotionSensor() {
        alarms = new ArrayList<>();
    }

    public static SchneiderMotionSensor getInstance()
    {
        if (obj == null)
        {
            // To make thread safe
            synchronized (SchneiderMotionSensor.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj==null)
                    obj = new SchneiderMotionSensor();
            }
        }
        return obj;
    }
    @Override
    public void turnOn() {
        System.out.println("Schneider Motion sensor turned on");
        obj.isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("Schneider Motion sensor turned off");
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
            System.out.println("alert :Motion Detected");

            alarms.stream()
                    .forEach(alarm -> alarm.turnOn());

            new SMSImp("Motion Detected",owner.getPhoneNumber()).send();
        }

    }

    @Override
    public void alertsOff() {
        System.out.println("(from Object) : turning alerts off");

        alarms.stream()
                .forEach(alarm -> alarm.turnOff());
    }
}
