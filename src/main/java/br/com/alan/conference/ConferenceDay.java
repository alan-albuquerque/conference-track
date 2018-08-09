package br.com.alan.conference;

import java.util.ArrayList;

public class ConferenceDay {

    private ArrayList<Session> sessions;
    private Integer startTime;
    private Integer endTime;

    public ConferenceDay(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public String toDisplay() {
        StringBuilder result = new StringBuilder();
        for (Session session : sessions) {
            result.append(session.toDisplay());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "ConferenceDay{" +
                "sessions=" + sessions +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
