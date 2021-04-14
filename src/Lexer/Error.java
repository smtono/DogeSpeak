package Lexer;

public class Error {
    // ERROR ATTRIBUTES
    String errorName;
    String details;

    // CONSTRUCTOR
    public Error(String errorName, String details) {
        this.errorName = errorName;
        this.details = details;
    }

    // HELPER METHODS
    @Override
    public String toString() {
        return "Error:" +
                "errorName= " + errorName +
                "details= " + details;
    }
}
