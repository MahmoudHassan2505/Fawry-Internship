package Sensor.Models;

import Actuators.Alarm;
import Data.Owner;

public interface Sensor {
    public void turnOn();
    public void turnOff();
    public void alert();
    public void addAlarm(Alarm alarm);
    public void removeAlarm(Alarm alarm);
    public void setOwner(Owner owner);
    public void alertsOff();
}
