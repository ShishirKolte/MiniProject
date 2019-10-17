package com.example.collegeevent;

public class participantDetailsGetter {

    private String participantName;
    private String participantCollege;
    private String participantEvent;
    private String participantMobile;
    private String participantEmail;
    private String participantYear;
    private String participantRegisterDate;
    private String participantRegisterTime;

    public participantDetailsGetter()
    {

    }

    public String getParticipantName() {
        return participantName;
    }

    public String getParticipantCollege() {
        return participantCollege;
    }

    public String getParticipantEvent() {
        return participantEvent;
    }

    public String getParticipantMobile() {
        return participantMobile;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public String getParticipantYear() {
        return participantYear;
    }

    public String getParticipantRegisterDate() {
        return participantRegisterDate;
    }

    public String getParticipantRegisterTime() {
        return participantRegisterTime;
    }

    public participantDetailsGetter(String participantName, String participantCollege, String participantEvent, String participantMobile, String participantEmail, String participantYear, String participantRegisterDate, String participantRegisterTime) {
        this.participantName = participantName;
        this.participantCollege = participantCollege;
        this.participantEvent = participantEvent;
        this.participantMobile = participantMobile;
        this.participantEmail = participantEmail;
        this.participantYear = participantYear;
        this.participantRegisterDate = participantRegisterDate;
        this.participantRegisterTime = participantRegisterTime;
    }
}
