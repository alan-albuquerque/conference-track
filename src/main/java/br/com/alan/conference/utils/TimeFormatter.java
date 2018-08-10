package br.com.alan.conference.utils;

public class TimeFormatter {
    public static String fromMinutes(int minutes) {
        long hours = minutes / 60;
        long minutesDiff = minutes % 60;
        String minutesDiffDisplay = String.format("%02d", minutesDiff);
        String hoursDisplay = String.format("%02d", hours);
        String periodAbbr = getPeriodHourAbbr(hours);
        return hoursDisplay + ":" + minutesDiffDisplay + periodAbbr;
    }

    public static String getPeriodHourAbbr(long hours) {
        return hours >= 12 ? Strings.POST_MERIDIEM_LABEL : Strings.ANTE_MERIDIEM_LABEL;
    }
}
