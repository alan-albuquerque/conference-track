package br.com.alan.conference;

import br.com.alan.conference.utils.Time;

public class SessionEvent {
    private int minutesDuration;
    private String name;
    private int scheduledTime;

    public SessionEvent(String name, int minutesDuration) {
        this.name = name;
        this.minutesDuration = minutesDuration;
    }

    public int getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(int minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toDisplay() {
        return Time.minutesToHumanReadable(scheduledTime) + ' ' + name;

    }

    public static SessionEvent fromTalk(Talk talk) {
        return new SessionEvent(talk.getTitle(), talk.getMinutesDuration());
    }

    public int getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(int scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    @Override
    public String toString() {
        return "SessionEvent{" +
                "minutesDuration=" + minutesDuration +
                ", name='" + name + '\'' +
                ", scheduledTime=" + scheduledTime +
                '}';
    }
}
