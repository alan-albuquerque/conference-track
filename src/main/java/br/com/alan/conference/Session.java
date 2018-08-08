package br.com.alan.conference;

import br.com.alan.conference.enums.SessionType;

import java.util.ArrayList;

public class Session {
    private SessionType sessionType;
    private ArrayList<SessionEvent> sessionEvents;

    public Session(SessionType sessionType) {
        this.sessionType = sessionType;
        this.sessionEvents = new ArrayList<>();
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public ArrayList<SessionEvent> getSessionEvents() {
        return sessionEvents;
    }

    public void addSessionEvent(SessionEvent sessionEvent) {
        this.sessionEvents.add(sessionEvent);
    }
}
