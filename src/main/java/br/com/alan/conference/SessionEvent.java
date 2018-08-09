package br.com.alan.conference;

public class SessionEvent {
    private Integer minutesDuration;
    private String name;

    public SessionEvent(String name, Integer minutesDuration) {
        this.name = name;
        this.minutesDuration = minutesDuration;
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

    public String toDisplay() {
        return name;
    }

    @Override
    public String toString() {
        return "SessionEvent{" +
                "minutesDuration=" + minutesDuration +
                ", name='" + name + '\'' +
                '}';
    }
}
