package Sensor.Models;

import Actuators.Alarm;
import Data.Owner;
import Message.SMSImp;

import java.util.ArrayList;

public class BoschSmokeSensor implements Sensor{
    private boolean isOn;
    private static BoschSmokeSensor obj;
    ArrayList<Alarm> alarms;
    private Owner owner;

    private BoschSmokeSensor() {
        alarms = new ArrayList<>();
    }

    public static BoschSmokeSensor getInstance()
    {
        if (obj == null)
        {
            synchronized (BoschSmokeSensor.class)
            {
                if (obj==null)
                    obj = new BoschSmokeSensor();
            }
        }
        return obj;
    }
    @Override
    public void turnOn() {
        System.out.println("BOSCH Smoke sensor turned on");
        obj.isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("BOSCH Smoke sensor turned off");
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
            System.out.println("alert : Smoke Detected ");

            alarms.stream()
                    .forEach(alarm -> alarm.turnOn());

            new SMSImp("Smoke Detected",owner.getPhoneNumber()).send();
        }

    }

    @Override
    public void alertsOff() {
        System.out.println("(from Object) : turning alerts off");

        alarms.stream()
                .forEach(alarm -> alarm.turnOff());
    }
}
