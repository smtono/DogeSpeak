package Error;

public class IllegalCharacterError extends Error {
    public IllegalCharacterError(String details) {
        super("Illegal Character", details);
    }


}
