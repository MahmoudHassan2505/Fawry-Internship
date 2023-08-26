package Sensor.AbstractFactory;

import Sensor.Models.Sensor;
import Sensor.Models.SensorEnum;

public abstract class SensorFactory {
    public abstract Sensor getSensor(SensorEnum sensor);
}
