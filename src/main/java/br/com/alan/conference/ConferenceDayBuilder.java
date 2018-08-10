package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;
import br.com.alan.conference.utils.Constants;
import br.com.alan.conference.utils.Strings;

public class ConferenceDayBuilder {

    private static Session buildLunchSession() {
        SessionEvent lunchEvent = new SessionEvent(Strings.LUNCH_EVENT_LABEL, Constants.LUNCH_MINUTES);
        Session lunchSession = new Session(Constants.LUNCH_START_TIME, Constants.LUNCH_MINUTES);
        try {
            lunchSession.addSessionEvent(lunchEvent);
        } catch (MinutesRemainingInsufficient e) {
            throw new IllegalStateException("Lunch session event duration granter than session duration.");
        }
        return lunchSession;
    }

    public static ConferenceDay build() {
        ConferenceDay conferenceDay = new ConferenceDay();

        Session morningSession = new Session(Constants.MORNING_START_TIME, Constants.MORNING_MINUTES);
        Session lunchSession = buildLunchSession();
        Session afternoonSession = new Session(Constants.AFTERNOON_START_TIME, Constants.AFTERNOON_MINUTES);

        SessionEvent networkingEvent = new SessionEvent(Strings.NETWORK_EVENT_LABEL, Constants.NETWORKING_MINUTES);
        afternoonSession.setNetworkingSessionEvent(networkingEvent);

        conferenceDay.addSession(morningSession);
        conferenceDay.addSession(lunchSession);
        conferenceDay.addSession(afternoonSession);

        return conferenceDay;
    }


}
