package br.com.alan.conference.utils;

import br.com.alan.conference.Talk;
import br.com.alan.conference.exceptions.InvalidTalkFileLineException;
import br.com.alan.conference.exceptions.InvalidTalkFileLineTimeException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TalkFileParser {

    private static Integer parseTalkMinutes(String value) throws InvalidTalkFileLineTimeException {
        if (value.toLowerCase().equals(Constants.TALK_LINE_LIGHTNING_PATTERN)) {
            return Constants.LIGHTENING_MINUTES;
        }
        final Pattern pattern = Pattern.compile(Constants.TALK_LINE_TIME_PATTERN);
        final Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new InvalidTalkFileLineTimeException(value);
        }
        return Integer.valueOf(matcher.group(1));
    }

    private static Talk parseLine(String line) throws InvalidTalkFileLineException, InvalidTalkFileLineTimeException {
        final Pattern pattern = Pattern.compile(Constants.TALK_LINE_PATTERN);
        final Matcher matcher = pattern.matcher(line);
        if (!matcher.matches()) {
            throw new InvalidTalkFileLineException(line);
        }
        final Integer minutes = parseTalkMinutes(matcher.group(2).trim());
        final String title = matcher.group(1).trim();
        return new Talk(title, minutes);
    }

    public static ArrayList<Talk> parse(String filePath) throws IOException, InvalidTalkFileLineException, InvalidTalkFileLineTimeException {
        final ArrayList<Talk> talks = new ArrayList<>();
        final File tracksFile = new File(filePath);
        final BufferedReader br = new BufferedReader(new FileReader(tracksFile));
        String line;
        while ((line = br.readLine()) != null) {
            Talk talk = parseLine(line);
            talks.add(talk);
        }
        return talks;
    }
}
