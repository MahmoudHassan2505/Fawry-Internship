package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SensorLogger {
    private static SensorLogger sensorlogger;
    FileHandler fileHandler;
    SimpleFormatter formatter;
    Logger logger;

    private SensorLogger(){
        if(sensorlogger!=null)
            throw new RuntimeException("Error");

        try {
            fileHandler = new FileHandler("SensorLog.txt");
            formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            logger = Logger.getLogger("MyLog");
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static SensorLogger getInstance(){
        if(sensorlogger==null){
            synchronized (SensorLogger.class){
                if (sensorlogger==null){
                    sensorlogger = new SensorLogger();
                }
            }
        }
        return sensorlogger;
    }

    public void addlog(String message){
        logger.info(message);

    }

}
