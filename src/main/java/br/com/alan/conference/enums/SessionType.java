package br.com.alan.conference.enums;

import br.com.alan.conference.utils.Constants;

public enum SessionType {
    MORNING(Constants.MORNING_MINUTES), AFTERNOON(Constants.AFTERNOON_MINUTES);

    private int minutes;

    SessionType(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}
