package com.example.collegeevent;

import java.io.Serializable;

public class eventDetailsGetter implements Serializable {

    private String eventName;
    private String eventDesc;
    private String eventAdmin;



    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public eventDetailsGetter() {
    }

    public eventDetailsGetter(int eventId, String eventName, String eventDescription, String eventAdmin) {

        this.eventName = eventName;
        this.eventDesc = eventDescription;
        this.eventAdmin = eventAdmin;
    }

    public String getEventAdmin() { return eventAdmin; }

    public String getEventName() {
        return eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }
}
