package Command;

import Actuators.Acuator;
import Sensor.Models.Sensor;

public class TurnOffActuators implements Command{
    Sensor sensor;
public TurnOffActuators(Sensor sensor){
    this.sensor=sensor;
}


    @Override
    public void execute() {
        sensor.alertsOff();
    }
}
