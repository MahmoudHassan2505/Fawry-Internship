package Sensor.AbstractFactory;

import Sensor.Models.BoschMotionSensor;
import Sensor.Models.BoschSmokeSensor;
import Sensor.Models.Sensor;
import Sensor.Models.SensorEnum;

public class BoschSensorsFactory extends SensorFactory{
    @Override
    public Sensor getSensor(SensorEnum sensor) {
        switch (sensor){

            case Smoke : return BoschSmokeSensor.getInstance();

            case Motion : return  BoschMotionSensor.getInstance();

            default : return null;
        }

    }
}
