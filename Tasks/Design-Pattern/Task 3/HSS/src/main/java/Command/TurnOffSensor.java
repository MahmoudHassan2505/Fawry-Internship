package Command;

import Sensor.Models.Sensor;

public class TurnOffSensor implements Command{
    private Sensor sensor;
    public TurnOffSensor(Sensor sensor){
        this.sensor=sensor;
    }
    @Override
    public void execute() {
        sensor.turnOff();
    }
}
