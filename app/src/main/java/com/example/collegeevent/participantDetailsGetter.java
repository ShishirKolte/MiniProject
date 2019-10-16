package com.example.collegeevent;

public class participantDetailsGetter {

    private String participantName;
    private String participantCollege;
    private String participantEvent;

    public participantDetailsGetter()
    {

    }

    public participantDetailsGetter(String participantName, String participantCollege, String participantEvent) {
        this.participantName = participantName;
        this.participantCollege = participantCollege;
        this.participantEvent = participantEvent;
    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantCollege() {
        return participantCollege;
    }

    public String getParticipantEvent(){ return  participantEvent; }
}
