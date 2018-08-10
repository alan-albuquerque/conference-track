package br.com.alan.conference;

import br.com.alan.conference.exceptions.InvalidTalkFileLineException;
import br.com.alan.conference.exceptions.InvalidTalkFileLineTimeException;
import br.com.alan.conference.exceptions.MinutesRemainingInsufficient;
import br.com.alan.conference.utils.Constants;
import br.com.alan.conference.utils.TalkFileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Conference conference = new Conference();
        String filePath;
        ArrayList<Talk> talks;

        try {
            filePath = args[0];
        } catch (Exception e) {
            logger.error("Missing input file path as first parameter.");
            return;
        }

        try {
            talks = TalkFileParser.parse(filePath);
        } catch (IOException e) {
            logger.error("Can't read file from path: " + filePath);
            return;
        } catch (InvalidTalkFileLineException e) {
            logger.error("Invalid line: " + e.getMessage());
            return;
        } catch (InvalidTalkFileLineTimeException e) {
            logger.error("Invalid time definition: " + e.getMessage());
            return;
        }

        while (!talks.isEmpty()) {
            ConferenceDay conferenceDay = ConferenceDayBuilder.build();
            if (conferenceDay.getSessions().isEmpty()) {
                break;
            }
            for (Session session : conferenceDay.getSessions()) {
                for (Iterator<Talk> iterator = talks.iterator(); iterator.hasNext(); ) {
                    if (!session.hasRemainingMinutes()) {
                        // no minutes left, finish the routine
                        break;
                    }
                    Talk talk = iterator.next();
                    int nextEventDurationLimit = session.getRemainingMinutes();
                    if (session.getNetworkingSessionEvent() != null) {
                        nextEventDurationLimit = session.getCurrentTime() - Constants.NETWORKING_MINUTES;
                    }
                    if (talk.getMinutesDuration() > nextEventDurationLimit) {
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
            conference.addDay(conferenceDay);
        }

        System.out.println(conference.toDisplay());

    }
}
