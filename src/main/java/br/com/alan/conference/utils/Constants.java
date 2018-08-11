package br.com.alan.conference.utils;

public class Constants {
    public static final int LIGHTENING_MINUTES = 5;
    public static final int MORNING_MINUTES = 180;
    public static final int LUNCH_MINUTES = 60;
    public static final int NETWORKING_MINUTES = 60;
    public static final int AFTERNOON_MINUTES = 240;
    public static final String TALK_LINE_TIME_PATTERN = "([0-9]*)min";
    public static final String TALK_LINE_LIGHTNING_PATTERN = "lightning";
    public static final String TALK_LINE_PATTERN = "(.+) (" + TALK_LINE_TIME_PATTERN + "|" + TALK_LINE_LIGHTNING_PATTERN + ")";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String TEST_FILES_LINE_SEPARATOR = "\n";

    public static final int MORNING_START_TIME = 540;
    public static final int LUNCH_START_TIME = MORNING_START_TIME + MORNING_MINUTES;
    public static final int AFTERNOON_START_TIME = LUNCH_START_TIME + LUNCH_MINUTES;

    public static final int NETWORKING_LIMIT_INIT_MINUTES = 960;

    public static final String NETWORK_EVENT_LABEL = "Networking Event";
    public static final String LUNCH_EVENT_LABEL = "Lunch";
    public static final String ANTE_MERIDIEM_LABEL = "AM";
    public static final String POST_MERIDIEM_LABEL = "PM";
}
