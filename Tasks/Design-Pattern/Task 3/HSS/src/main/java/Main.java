import Actuators.Alarm;
import Command.RemoteControl;
import Command.TurnOffActuators;
import Command.TurnOnSensor;
import Data.Owner;
import Sensor.AbstractFactory.BoschSensorsFactory;
import Sensor.Models.Sensor;
import Sensor.Models.SensorEnum;
import logger.SensorLogger;


public class Main {
    public static void main(String[] args) {
        //add Remote Control
        RemoteControl remote = new RemoteControl();

        // getting Motion Sensor (BOSCH)
        BoschSensorsFactory boschSensorsFactory = new BoschSensorsFactory();
        Sensor boschMotionSensor = boschSensorsFactory.getSensor(SensorEnum.Motion);

        // Adding Alarms
        Alarm alarm1 = new Alarm("alarm1");
        Alarm alarm2 = new Alarm("alarm2");
        Alarm alarm3 = new Alarm("alarm3");
        Alarm alarm4 = new Alarm("alarm4");

        // add Alarm to sensor
        boschMotionSensor.addAlarm(alarm1);
        boschMotionSensor.addAlarm(alarm2);
        boschMotionSensor.addAlarm(alarm3);

        //turn sensor on
        remote.setCommand(new TurnOnSensor(boschMotionSensor));
        remote.press();

        // adding Owner
        boschMotionSensor.setOwner(new Owner("Mahmoud", 265012));

        // if there is a smoke
        boschMotionSensor.alert();

        // turn alerts off
        remote.setCommand(new TurnOffActuators(boschMotionSensor));
        remote.press();





    }
}