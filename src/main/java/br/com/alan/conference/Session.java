package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;
import br.com.alan.conference.utils.Constants;

import java.util.ArrayList;

public class Session {
    private ArrayList<SessionEvent> sessionEvents;

    private int startTime;
    private int maxDuration;
    private int remainingMinutes;
    private int currentTime;
    private SessionEvent networkingSessionEvent;

    public Session(int startTime, int maxDuration) {
        this.sessionEvents = new ArrayList<>();
        this.startTime = startTime;
        this.currentTime = startTime;
        this.remainingMinutes = maxDuration;
        this.maxDuration = maxDuration;
    }


    public boolean hasRemainingMinutes(int minutes) {
        return remainingMinutes >= minutes;
    }

    public boolean hasRemainingMinutes() {
        return remainingMinutes > 0;
    }

    public void addSessionEvent(SessionEvent sessionEvent) throws MinutesRemainingInsufficient {
        if (!hasRemainingMinutes(sessionEvent.getMinutesDuration())) {
            throw new MinutesRemainingInsufficient();
        }
        this.sessionEvents.add(sessionEvent);
        sessionEvent.setScheduledTime(currentTime);
        int minutesDuration = sessionEvent.getMinutesDuration();
        remainingMinutes -= minutesDuration;
        currentTime += minutesDuration;
    }

    public void putNetworkingEventAtSessionEnd() {
        if (networkingSessionEvent == null) {
            return;
        }
        if (currentTime < Constants.NETWORKING_LIMIT_INIT_MINUTES) {
            currentTime = Constants.NETWORKING_LIMIT_INIT_MINUTES;
        }
        try {
            addSessionEvent(networkingSessionEvent);
        } catch (MinutesRemainingInsufficient e) {
            remainingMinutes += Constants.NETWORKING_MINUTES - remainingMinutes;
            putNetworkingEventAtSessionEnd();
        }
    }

    public String toDisplay() {
        StringBuilder result = new StringBuilder();
        for (SessionEvent sessionEvent : sessionEvents) {
            result.append(sessionEvent.toDisplay())
                    .append(Constants.LINE_SEPARATOR);
        }
        return result.toString();
    }

    public ArrayList<SessionEvent> getSessionEvents() {
        return sessionEvents;
    }

    public void setSessionEvents(ArrayList<SessionEvent> sessionEvents) {
        this.sessionEvents = sessionEvents;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(int remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public SessionEvent getNetworkingSessionEvent() {
        return networkingSessionEvent;
    }

    public void setNetworkingSessionEvent(SessionEvent networkingSessionEvent) {
        this.networkingSessionEvent = networkingSessionEvent;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionEvents=" + sessionEvents +
                ", maxDuration=" + maxDuration +
                ", remainingMinutes=" + remainingMinutes +
                '}';
    }

}
