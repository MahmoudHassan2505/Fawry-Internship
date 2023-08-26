package Sensor.Models;

import Actuators.Alarm;
import Data.Owner;
import logger.SensorLogger;

public interface Sensor {
    public void turnOn();
    public void turnOff();
    public void alert();
    public void addAlarm(Alarm alarm);
    public void removeAlarm(Alarm alarm);
    public void setOwner(Owner owner);
    public void alertsOff();

    default void sensorLog(String message){
        SensorLogger sensorLogger = SensorLogger.getInstance();
        sensorLogger.addlog(message);
    }
}
