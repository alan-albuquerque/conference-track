package br.com.alan.conference.utils;

import br.com.alan.conference.Talk;
import org.junit.Test;
import utils.Resources;

import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TalkFileParserTest {

    @Test
    public void testParse() throws Exception {
        Path fixturePath = Resources.absolutePath("/input_two_talks.txt", this.getClass());
        ArrayList<Talk> talks = TalkFileParser.parse(fixturePath.toString());

        Talk talk1 = talks.get(0);
        assertEquals(60, (int) talk1.getMinutesDuration());
        assertEquals("Writing Fast Tests Against Enterprise Rails", talk1.getTitle());

        Talk talk2 = talks.get(1);
        assertEquals(45, (int) talk2.getMinutesDuration());
        assertEquals("Overdoing it in Python", talk2.getTitle());
    }

    @Test
    public void testParseWithLightning() throws Exception {
        Path fixturePath = Resources.absolutePath("/input_lightening_talk.txt", this.getClass());
        ArrayList<Talk> talks = TalkFileParser.parse(fixturePath.toString());

        Talk talk = talks.get(0);
        assertEquals(Constants.LIGHTENING_MINUTES, (int) talk.getMinutesDuration());
        assertEquals("Rails for Python Developers", talk.getTitle());
    }
}