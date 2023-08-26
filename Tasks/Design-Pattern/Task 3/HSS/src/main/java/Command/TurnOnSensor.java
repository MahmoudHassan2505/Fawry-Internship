package Command;

import Sensor.Models.Sensor;

public class TurnOnSensor implements Command {
    private Sensor sensor;
    public TurnOnSensor(Sensor sensor){
        this.sensor=sensor;
    }
    @Override
    public void execute() {
        sensor.turnOn();
    }
}
