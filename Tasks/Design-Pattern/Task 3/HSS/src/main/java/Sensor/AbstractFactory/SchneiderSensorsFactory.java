package Sensor.AbstractFactory;

import Sensor.Models.*;

public class SchneiderSensorsFactory extends SensorFactory{

    @Override
    public Sensor getSensor(SensorEnum sensor) {
        switch (sensor){

            case Smoke : return  SchneiderSmokeSensor.getInstance();

            case Motion : return  SchneiderMotionSensor.getInstance();

            default : return null;
        }

    }
}
