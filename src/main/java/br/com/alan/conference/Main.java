package br.com.alan.conference;

import br.com.alan.conference.exceptions.InvalidTalkFileLineException;
import br.com.alan.conference.utils.TalkFileParser;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference();
        final Integer startTime = 9 * 60; // 9h
        final Integer endTime = 18 * 60; // 18h
        String filePath = args[0];

        try {

            // 1 - creating Talk list from file
            ArrayList<Talk> talks = TalkFileParser.parse(filePath);
//            System.out.println(talks.toString());
            while (!talks.isEmpty()) {
                ConferenceDay conferenceDay = ConferenceDayBuilder.build(startTime, endTime);
                if (conferenceDay.getSessions().isEmpty()) {
                    break;
                }
                for (Session session : conferenceDay.getSessions()) {
                    session.organizeTalks(talks);
                }
                conference.addDay(conferenceDay);
            }

            System.out.println(conference.toDisplay());

        } catch (IOException | InvalidTalkFileLineException e) {
            e.printStackTrace();
        }

    }
}
