import Actuators.Alarm;
import Data.Owner;
import Sensor.AbstractFactory.BoschSensorsFactory;
import Sensor.Models.BoschMotionSensor;
import Sensor.Models.BoschSmokeSensor;
import Sensor.Models.Sensor;
import Sensor.Models.SensorEnum;

public class Main {
    public static void main(String[] args) {
        // getting Motion Sensor (BOSCH)
        BoschSensorsFactory boschSensorsFactory = new BoschSensorsFactory();
        Sensor boschMotionSensor = boschSensorsFactory.getSensor(SensorEnum.Motion);

        // Adding Alarms
        Alarm alarm1 = new Alarm("alarm1");
        Alarm alarm2 = new Alarm("alarm2");
        Alarm alarm3 = new Alarm("alarm3");
        Alarm alarm4 = new Alarm("alarm4");

        // Turning Sensor on and add Alarm
        boschMotionSensor.turnOn();
        boschMotionSensor.addAlarm(alarm1);
        boschMotionSensor.addAlarm(alarm2);
        boschMotionSensor.addAlarm(alarm3);

        // adding Owner
        boschMotionSensor.setOwner(new Owner("Mahmoud", 265012));

        // if there is a smoke
        boschMotionSensor.alert();

        // turn alerts off
        boschMotionSensor.alertsOff();

        // remove alert 2 and set alarms again
//        boschMotionSensor.removeAlarm(alarm2);
//        boschMotionSensor.alert();

    }
}