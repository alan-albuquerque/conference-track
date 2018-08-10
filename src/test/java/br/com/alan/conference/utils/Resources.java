package br.com.alan.conference.utils;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Resources {
    public static String asString(String filePath, Class testClass) throws Exception {
        Path path = absolutePath(filePath, testClass);
        return new String(Files.readAllBytes(path), "UTF8");
    }

    public static Path absolutePath(String filePath, Class testClass) throws Exception {
        URL url = testClass.getResource(filePath);
        return Paths.get(url.toURI());
    }
}
