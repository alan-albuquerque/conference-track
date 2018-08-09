package br.com.alan.conference;

import java.util.ArrayList;

public class Conference {
    private ArrayList<ConferenceDay> days;

    public Conference() {
        this.days = new ArrayList<>();
    }

    public void addDay(ConferenceDay conferenceDay) {
        this.days.add(conferenceDay);
    }

    public ArrayList<ConferenceDay> getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "days=" + days +
                '}';
    }
}
