package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;
import br.com.alan.conference.utils.Constants;

import java.util.ArrayList;
import java.util.Iterator;

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


    public void organizeWithTalks(ArrayList<Talk> talks) {
        for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext(); ) {
            if (!hasRemainingMinutes()) {
                // no minutes left, finish the routine
                return;
            }
            Talk talk = iterator.next();
            int nextEventDurationLimit = remainingMinutes;
            if (networkingSessionEvent != null) {
                nextEventDurationLimit = currentTime - Constants.NETWORKING_MINUTES;
            }
            if (talk.getMinutesDuration() > nextEventDurationLimit) {
                // continue and try to add another with less time
                continue;
            }
            SessionEvent sessionEvent = SessionEvent.fromTalk(talk);
            try {
                addSessionEvent(sessionEvent);
                iterator.remove();
            } catch (MinutesRemainingInsufficient e) {
                // continue and try to add another with less time
            }
        }
        placeNetworkingEventAtSessionEnd();
    }

    private void placeNetworkingEventAtSessionEnd() {
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
            placeNetworkingEventAtSessionEnd();
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

    public void setNetworkingSessionEvent(SessionEvent networkingSessionEvent) {
        this.networkingSessionEvent = networkingSessionEvent;
    }

    public void setSessionEvents(ArrayList<SessionEvent> sessionEvents) {
        this.sessionEvents = sessionEvents;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(int remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }

    public ArrayList<SessionEvent> getSessionEvents() {
        return sessionEvents;
    }

    public int getMaxDuration() {
        return maxDuration;
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
