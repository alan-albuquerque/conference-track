package br.com.alan.conference;

import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;
import br.com.alan.conference.utils.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public class ConferenceBuilder {

    private static void scheduleTalksInSession(Session session, ArrayList<Talk> talks) {
        for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext(); ) {
            if (!session.hasRemainingMinutes()) {
                // no minutes left, finish the routine
                break;
            }
            Talk talk = iterator.next();
            int maxDurationNextEvent = session.getRemainingMinutes();
            if (session.getNetworkingSessionEvent() != null) {
                maxDurationNextEvent = session.getCurrentTime() - Constants.NETWORKING_MINUTES;
            }
            if (talk.getMinutesDuration() > maxDurationNextEvent) {
                // continue and try to add another with less time
                continue;
            }
            SessionEvent sessionEvent = SessionEvent.fromTalk(talk);
            try {
                session.addSessionEvent(sessionEvent);
                iterator.remove();
            } catch (MinutesRemainingInsufficient e) {
                // continue and try to add another with less time
            }
        }
        session.putNetworkingEventAtSessionEnd();
    }

    public static Conference build(ArrayList<Talk> talksSourceList) {
        final ArrayList<Talk> talks = new ArrayList<>(talksSourceList);
        final Conference conference = new Conference();

        while (!talks.isEmpty()) {
            ConferenceDay conferenceDay = ConferenceDayBuilder.build();
            if (conferenceDay.getSessions().isEmpty()) {
                break;
            }
            for (Session session : conferenceDay.getSessions()) {
                scheduleTalksInSession(session, talks);
            }
            conference.addDay(conferenceDay);
        }

        return conference;

    }

}
