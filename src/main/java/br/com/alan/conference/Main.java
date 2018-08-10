package br.com.alan.conference;

import br.com.alan.conference.exceptions.InvalidTalkFileLineException;
import br.com.alan.conference.exceptions.InvalidTalkFileLineTimeException;
import br.com.alan.conference.utils.TalkFileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
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

        Conference conference = ConferenceBuilder.build(talks);
        System.out.println(conference.toDisplay());

    }
}
