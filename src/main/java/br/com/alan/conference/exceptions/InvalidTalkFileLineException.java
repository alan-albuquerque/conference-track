package br.com.alan.conference.exceptions;

public class InvalidTalkFileLineException extends Exception {
    public InvalidTalkFileLineException(String lineContent) {
        super(lineContent);
    }
}
