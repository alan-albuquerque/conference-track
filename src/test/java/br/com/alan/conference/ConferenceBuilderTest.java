package br.com.alan.conference;

import br.com.alan.conference.utils.Constants;
import br.com.alan.conference.utils.TalkFileParser;
import org.junit.Test;
import utils.Resources;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConferenceBuilderTest {

    @Test
    public void testBuild() throws Exception {
        Path path = Resources.absolutePath("/input.txt", this.getClass());
        String outputContentExpected = Resources.asString("/output.txt", this.getClass());
        ArrayList<Talk> talks = TalkFileParser.parse(path.toString());
        Conference conference = ConferenceBuilder.build(talks);
        assertNotNull(conference);
        String[] a = conference.toDisplay().split(Constants.LINE_SEPARATOR);
        String[] b = outputContentExpected.replaceAll("\uFEFF|\\r", "").split(Constants.LINE_SEPARATOR);
        assertTrue(Arrays.equals(a, b));
        assertNotNull(conference);
    }
}