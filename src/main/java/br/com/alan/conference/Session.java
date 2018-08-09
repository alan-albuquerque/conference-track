package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;

import java.util.ArrayList;
import java.util.Iterator;

public class Session {
    private ArrayList<SessionEvent> sessionEvents;

    private Integer maxDuration;
    private Integer remainingMinutes;

    public Session(Integer maxDuration) {
        this.sessionEvents = new ArrayList<>();
        this.maxDuration = maxDuration;
        this.remainingMinutes = maxDuration;
    }

    public void setSessionEvents(ArrayList<SessionEvent> sessionEvents) {
        this.sessionEvents = sessionEvents;
    }

    public Integer getRemainingMinutes() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(Integer remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }

    public ArrayList<SessionEvent> getSessionEvents() {
        return sessionEvents;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public Boolean hasRemainingMinutes(Integer minutes) {
        return remainingMinutes >= minutes;
    }

    public void addSessionEvent(SessionEvent sessionEvent) throws MinutesRemainingInsufficient {
        if (!hasRemainingMinutes(sessionEvent.getMinutesDuration())) {
            throw new MinutesRemainingInsufficient();
        }
        this.sessionEvents.add(sessionEvent);
        remainingMinutes -= sessionEvent.getMinutesDuration();
    }


    public void organizeTalks(ArrayList<Talk> talks) {
        for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext(); ) {
            if (remainingMinutes == 0) {
                // no minutes left, finish the routine
                return;
            }
            Talk talk = iterator.next();
            try {
                addSessionEvent(new SessionEvent(talk.getTitle(), talk.getMinutesDuration()));
                iterator.remove();
            } catch (MinutesRemainingInsufficient e) {
                // continue and try to add another with less time
            }
        }
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
