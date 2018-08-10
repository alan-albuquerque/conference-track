package br.com.alan.conference.utils;

public class TimeFormatter {
    public static String fromMinutes(int minutes) {
        final long hours = minutes / 60;
        final long minutesDiff = minutes % 60;
        final String minutesDiffDisplay = String.format("%02d", minutesDiff);
        final String hoursDisplay = String.format("%02d", hours);
        final String periodAbbr = getPeriodHourAbbr(hours);
        return hoursDisplay + ":" + minutesDiffDisplay + periodAbbr;
    }

    public static String getPeriodHourAbbr(long hours) {
        return hours >= 12 ? Constants.POST_MERIDIEM_LABEL : Constants.ANTE_MERIDIEM_LABEL;
    }
}
