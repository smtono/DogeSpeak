package Error;

public class GenericError {
    // ERROR ATTRIBUTES
    private final String errorName;
    private final String details;

    // CONSTRUCTOR
    public GenericError(String errorName, String details) {
        this.errorName = errorName;
        this.details = details;
    }

    // ACCESSORS
    public String getErrorName() { return errorName; }
    public String getDetails() { return details; }

    // HELPER METHODS
    @Override
    public String toString() {
        return "Error:" +
                "errorName= " + errorName +
                "details= " + details;
    }
}
