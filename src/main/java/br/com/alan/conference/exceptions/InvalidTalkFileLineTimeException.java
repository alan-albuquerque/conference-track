package br.com.alan.conference.exceptions;

public class InvalidTalkFileLineTimeException extends Exception {
    public InvalidTalkFileLineTimeException(String timeText) {
        super(timeText);
    }
}
