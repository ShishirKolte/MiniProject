package com.example.collegeevent;

import java.io.Serializable;

public class eventDetailsGetter implements Serializable {

    private String eventName;
    private String eventDesc;
    private String eventAdmin;
    private  String eventDate;
    private String eventTime;
    private String eventLevels;
    private String eventCompetition;

    public eventDetailsGetter() {
    }

    public eventDetailsGetter(String eventName, String eventDesc, String eventAdmin, String eventDate, String eventTime, String eventLevels, String eventCompetition) {
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventAdmin = eventAdmin;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLevels = eventLevels;
        this.eventCompetition = eventCompetition;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public String getEventAdmin() {
        return eventAdmin;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLevels() {
        return eventLevels;
    }

    public String getEventCompetition() { return  eventCompetition; }
}
