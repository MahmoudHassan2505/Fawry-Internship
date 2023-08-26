package Sensor.AbstractFactory;

import Sensor.Models.*;

public class SchneiderSensorsFactory extends SensorFactory{

    @Override
    public Sensor getSensor(SensorEnum sensor) {
        switch (sensor){

            case Smoke : return new SchneiderSmokeSensor();

            case Motion : return new SchneiderMotionSensor();

            default : return null;
        }

    }
}
