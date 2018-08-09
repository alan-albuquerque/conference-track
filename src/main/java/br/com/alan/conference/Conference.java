package br.com.alan.conference;

import br.com.alan.conference.utils.Constants;

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

    public String toDisplay() {
        final StringBuilder result = new StringBuilder();
        int trackId;
        for (ConferenceDay conferenceDay : days) {
            trackId = days.indexOf(conferenceDay) + 1;
            result.append("Track ")
                    .append(trackId)
                    .append(":")
                    .append(Constants.LINE_SEPARATOR)
                    .append(conferenceDay.toDisplay())
                    .append(Constants.LINE_SEPARATOR);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Conference{" +
                "days=" + days +
                '}';
    }
}
