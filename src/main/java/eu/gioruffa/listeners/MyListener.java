package eu.gioruffa.listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import eu.gioruffa.events.TemperatureEvent;

public class MyListener implements UpdateListener {

    public void update(EventBean[] eventBeans, EventBean[] eventBeans1) {
        if (eventBeans != null) { //new
            for (EventBean eventBean : eventBeans) {
                try {

                    System.out.println("Event received IN: " + eventBean.get("temperature"));
                    //to get the object
                    //can cast
                    TemperatureEvent te = (TemperatureEvent) eventBean.getUnderlying();
                    System.out.println("Sensor received IN: " + te.getSensorID());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (eventBeans1 != null) //old
        {
            for (EventBean eventBean : eventBeans1) {
                try {

                    System.out.println("Event received OUT: " + eventBean.get("temperature"));
                    //to get the object
                    //can cast
                    TemperatureEvent te = (TemperatureEvent) eventBean.getUnderlying();
                    System.out.println("Sensor received OUT: " + te.getSensorID());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
