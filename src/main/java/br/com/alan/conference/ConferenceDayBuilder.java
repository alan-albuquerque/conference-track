package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;

import static br.com.alan.conference.utils.Constants.*;

public class ConferenceDayBuilder {

    public static ConferenceDay build(Integer startTime, Integer endTime) {
        ConferenceDay conferenceDay = new ConferenceDay(startTime, endTime);

        Session morningSession = new Session(MORNING_START_TIME, MORNING_MINUTES);

        SessionEvent lunchEvent = new SessionEvent("Lunch", 60);
        Session lunchSession = new Session(LUNCH_START_TIME, LUNCH_MINUTES);

        try {
            lunchSession.addSessionEvent(lunchEvent);
        } catch (MinutesRemainingInsufficient e) {
            e.printStackTrace();
        }

        Session afternoonSession = new Session(AFTERNOON_START_TIME, AFTERNOON_MINUTES);

        SessionEvent networkingEvent = new SessionEvent("Networking Event", 60);
        Session networkingSession = new Session();

        try {
            networkingSession.addSessionEvent(networkingEvent);
        } catch (MinutesRemainingInsufficient e) {
            e.printStackTrace();
        }

        conferenceDay.addSession(morningSession);
        conferenceDay.addSession(lunchSession);
        conferenceDay.addSession(afternoonSession);
        conferenceDay.addSession(networkingSession);

        return conferenceDay;
    }


}
