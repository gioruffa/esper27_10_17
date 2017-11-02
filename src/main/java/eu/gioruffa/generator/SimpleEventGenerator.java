package eu.gioruffa.generator;

import com.espertech.esper.client.EPRuntime;
import eu.gioruffa.events.TemperatureEvent;

import java.util.Date;
import java.util.Random;

public class SimpleEventGenerator {
    EPRuntime runtime;

    public SimpleEventGenerator(EPRuntime runtime) {
        this.runtime = runtime;
    }

    public void generateBlocking()
    {
//        TemperatureEvent event = new TemperatureEvent()
        int count = 10;
        while (count > 0) {
            TemperatureEvent tempEvent = new TemperatureEvent(
                    "sensorX",
                    (double) (new Random().nextInt(100)),
                    new Date()
            );
            runtime.sendEvent(tempEvent);
            count --;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
