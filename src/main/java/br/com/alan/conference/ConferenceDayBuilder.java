package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;
import br.com.alan.conference.utils.Constants;

public class ConferenceDayBuilder {

    private static Session buildLunchSession() {
        final SessionEvent lunchEvent = new SessionEvent(Constants.LUNCH_EVENT_LABEL, Constants.LUNCH_MINUTES);
        final Session lunchSession = new Session(Constants.LUNCH_START_TIME, Constants.LUNCH_MINUTES);
        try {
            lunchSession.addSessionEvent(lunchEvent);
        } catch (MinutesRemainingInsufficient e) {
            throw new IllegalStateException("Lunch session event duration granter than session duration.");
        }
        return lunchSession;
    }

    public static ConferenceDay build() {
        final ConferenceDay conferenceDay = new ConferenceDay();

        final Session morningSession = new Session(Constants.MORNING_START_TIME, Constants.MORNING_MINUTES);
        final Session lunchSession = buildLunchSession();
        final Session afternoonSession = new Session(Constants.AFTERNOON_START_TIME, Constants.AFTERNOON_MINUTES);

        final SessionEvent networkingEvent = new SessionEvent(Constants.NETWORK_EVENT_LABEL, Constants.NETWORKING_MINUTES);
        afternoonSession.setNetworkingSessionEvent(networkingEvent);

        conferenceDay.addSession(morningSession);
        conferenceDay.addSession(lunchSession);
        conferenceDay.addSession(afternoonSession);

        return conferenceDay;
    }


}
