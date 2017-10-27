package eu.gioruffa.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import eu.gioruffa.events.TemperatureEvent;

public class MyListener implements UpdateListener {

    public void update(EventBean[] eventBeans, EventBean[] eventBeans1) {
        for (EventBean eventBean : eventBeans)
        {
            try{

                System.out.println("Event received: " + eventBean.get("temperature"));
                //to get the object
                //can cast
                TemperatureEvent te = (TemperatureEvent)eventBean.getUnderlying();
                System.out.println("Sensor received: " + te.getSensorID());

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            //or you can cast
        }
    }
}
