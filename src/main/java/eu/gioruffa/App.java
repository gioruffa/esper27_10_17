package eu.gioruffa;

import com.espertech.esper.client.*;
import eu.gioruffa.events.TemperatureEvent;
import eu.gioruffa.generator.SimpleEventGenerator;
import eu.gioruffa.listeners.MyListener;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EPServiceProvider epServiceProvider = EPServiceProviderManager.getProvider("gioruffa.eu");
//        to register streams need the administrator console
        EPAdministrator epAdministrator = epServiceProvider.getEPAdministrator();
//        to send events need runtime
        EPRuntime epRuntime = epServiceProvider.getEPRuntime();

        //register the stream in the environment
        epAdministrator.getConfiguration().addEventType("temperatureStream", TemperatureEvent.class);

        //now we create the query
        //windowing
        String tempStupidQuery = "select irstream * from temperatureStream.win:time(2 sec)";
        EPStatement statement = epAdministrator.createEPL(tempStupidQuery);

        //then listen for results of the query
        statement.addListener(new MyListener());

        //now we need to send the events
        TemperatureEvent te1 = new TemperatureEvent("sensor1", 18.0, new Date());
        TemperatureEvent te2 = new TemperatureEvent("sensor1", 19.0, new Date());
        TemperatureEvent te3 = new TemperatureEvent("sensor1", 18.0, new Date());

//        epRuntime.sendEvent(te1);
//        epRuntime.sendEvent(te2);
//        epRuntime.sendEvent(te3);


        //multiple query per stream -> calls all the queries per stream.

        SimpleEventGenerator simpleEventGenerator = new SimpleEventGenerator(epRuntime);
        simpleEventGenerator.generateBlocking();

    }
}
