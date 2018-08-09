package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;

public class ConferenceDayBuilder {

    public static ConferenceDay build(Integer startTime, Integer endTime) {
        ConferenceDay conferenceDay = new ConferenceDay(startTime, endTime);

        Session morningSession = new Session(60 * 3);

        SessionEvent lunchEvent = new SessionEvent("Lunch", 60);
        Session lunchSession = new Session(60);

        try {
            lunchSession.addSessionEvent(lunchEvent);
        } catch (MinutesRemainingInsufficient e) {
            e.printStackTrace();
        }

        Session afternoonSession = new Session(4 * 60);

        SessionEvent networkingEvent = new SessionEvent("Networking Event", 60);
        Session networkingSession = new Session(60);

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
