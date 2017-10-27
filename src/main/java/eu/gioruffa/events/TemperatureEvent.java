package eu.gioruffa.events;

import java.util.Date;

public class TemperatureEvent {

    /**
     * fieldnames are the same that you are going to use in the EPL (SQL-like)
     */
    String sensorID;
    Double temperature;

    public TemperatureEvent(String sensorID, Double temperature) {
        this.sensorID = sensorID;
        this.temperature = temperature;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }


}
