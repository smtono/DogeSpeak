package Error;

public class GenericError {
    // ERROR ATTRIBUTES
    String errorName;
    String details;

    // CONSTRUCTOR
    public GenericError(String errorName, String details) {
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
