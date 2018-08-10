package br.com.alan.conference;

import java.util.ArrayList;

public class ConferenceDay {

    private ArrayList<Session> sessions;

    public ConferenceDay() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public String toDisplay() {
        final StringBuilder result = new StringBuilder();
        for (Session session : sessions) {
            result.append(session.toDisplay());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "ConferenceDay{" +
                "sessions=" + sessions +
                '}';
    }
}
