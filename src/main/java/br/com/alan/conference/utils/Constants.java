package br.com.alan.conference.utils;

public class Constants {
    public static final int LIGHTENING_MINUTES = 5;
    public static final int MORNING_MINUTES = 180;
    public static final int LUNCH_MINUTES = 60;
    public static final int AFTERNOON_MINUTES = 240;
    public static final String TALK_LINE_TIME_PATTERN = "([0-9]*)min";
    public static final String TALK_LINE_LIGHTNING_PATTERN = "lightning";
    public static final String TALK_LINE_PATTERN = "(.+) (" + TALK_LINE_TIME_PATTERN + "|" + TALK_LINE_LIGHTNING_PATTERN + ")";

}
