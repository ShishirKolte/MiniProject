package com.example.collegeevent;

public class eventDetailsGetter {

    private int eventId;
    private String eventName;
    private String eventDesc;

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public eventDetailsGetter() {
    }

    public eventDetailsGetter(int eventId, String eventName, String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDesc = eventDescription;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }
}
