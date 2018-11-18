package pl.edu.agh.visca.command;

public enum ResponseMatch {
    ACK(".0 4. FF", "Accepted"),
    COMPLETED(".0 5. FF", "Completed"),
    SYNTAX(".0 60 02 FF", "S.ntax error"),
    BUFFER_FULL(".0 60 03 FF", "Command buffer full"),
    CANCELLED(".0 6. 04 FF", "Command cancelled"),
    NO_SOCKET(".0 6. 05 FF", "No socket"),
    NOT_EXECUTABLE(".0 6. 41 FF", "Command not executable");

    ResponseMatch(String pattern, String message) {
        this.pattern = pattern;
        this.message = message;
    }

    private String pattern;

    private String message;

    public String getPattern() {
        return pattern;
    }

    public String getMessage() {
        return message;
    }
}
