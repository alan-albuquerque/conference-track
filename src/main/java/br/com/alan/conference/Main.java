package br.com.alan.conference;

import br.com.alan.conference.exceptions.InvalidTalkFileLineException;
import br.com.alan.conference.utils.TalkFileParser;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference();

        String filePath = args[0];

        try {
            ArrayList<Talk> talks = TalkFileParser.parse(filePath);
            System.out.println(talks.toString());
        } catch (IOException | InvalidTalkFileLineException e) {
            e.printStackTrace();
        }

//        br.com.alan.conference.SessionEvent morning = new br.com.alan.conference.SessionEvent(60, "Python");
//        br.com.alan.conference.Session morningSession = new br.com.alan.conference.Session(SessionType.MORNING);
//        br.com.alan.conference.Session afternoonSession = new br.com.alan.conference.Session(SessionType.AFTERNOON);
//        conference.
    }
}