package br.com.alan.conference;

public class SessionEvent {
    private Integer minutesDuration;
    private String name;

    public SessionEvent(Integer minutesDuration, String name) {
        this.minutesDuration = minutesDuration;
        this.name = name;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(Integer minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
