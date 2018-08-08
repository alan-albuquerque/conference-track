package br.com.alan.conference;

public class Talk {
    private String title;
    private Integer minutesDuration;

    public Talk(String title, Integer minutesDuration) {
        this.title = title;
        this.minutesDuration = minutesDuration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(Integer minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "title='" + title + '\'' +
                ", minutesDuration=" + minutesDuration +
                '}';
    }
}
