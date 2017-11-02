package eu.gioruffa.events;

import java.util.Date;

public class TemperatureEvent {

    /**
     * fieldnames are the same that you are going to use in the EPL (SQL-like)
     */
    String sensorID;
    Double temperature;
    Date timestamp;

    public TemperatureEvent(String sensorID, Double temperature, Date timestamp) {
        this.sensorID = sensorID;
        this.temperature = temperature;
        this.timestamp = timestamp;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
