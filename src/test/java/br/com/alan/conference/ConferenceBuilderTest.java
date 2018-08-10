package br.com.alan.conference;

import br.com.alan.conference.utils.Resources;
import br.com.alan.conference.utils.TalkFileParser;
import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class ConferenceBuilderTest {

    @Test
    public void build() throws Exception {
        Path path = Resources.absolutePath("/input.txt", this.getClass());
        ArrayList<Talk> talks = TalkFileParser.parse(path.toString());
        Conference conference = ConferenceBuilder.build(talks);
        assertNotNull(conference);
    }
}