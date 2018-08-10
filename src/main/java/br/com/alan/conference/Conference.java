package br.com.alan.conference;

import br.com.alan.conference.utils.Constants;

import java.util.ArrayList;

public class Conference {
    private ArrayList<ConferenceDay> conferenceDays;

    public Conference() {
        this.conferenceDays = new ArrayList<>();
    }

    public void addDay(ConferenceDay conferenceDay) {
        this.conferenceDays.add(conferenceDay);
    }

    public ArrayList<ConferenceDay> getConferenceDays() {
        return conferenceDays;
    }

    public String toDisplay() {
        final StringBuilder result = new StringBuilder();
        for (ConferenceDay conferenceDay : conferenceDays) {
            int trackId = conferenceDays.indexOf(conferenceDay) + 1;
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
                "conferenceDays=" + conferenceDays +
                '}';
    }
}
