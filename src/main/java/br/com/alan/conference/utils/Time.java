package br.com.alan.conference.utils;

public class Time {
    public static String minutesToHumanReadable(Integer minutes) {
        long hours = minutes / 60;
        long minutesDiff = minutes % 60;
        String minutesDiffDisplay = String.format("%02d", minutesDiff);
        String periodAbbr = "";
        return hours + ":" + minutesDiffDisplay + periodAbbr;
    }
}
