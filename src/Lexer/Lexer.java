package Lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    // LEXER ATTRIBUTES
    private final String text;
    private int currentPosition;
    private char currentCharacter;

    // CONSTRUCTOR
    public Lexer(String text) {
        this.text = text;
        currentPosition = -1;
        currentCharacter = '\u0000'; // Default null character
        advance();
    }

    // ACCESSORS
    public String getText() { return text; }
    public int getCurrentPosition() { return currentPosition; }
    public char getCurrentCharacter() { return currentCharacter; }

    // HELPER METHODS
    /** Goes to the next character in the text */
    public void advance() {
        this.currentPosition += 1;
        if (this.currentPosition < text.length()) {
            this.currentCharacter = text.charAt(currentPosition);
        }
        else {
            this.currentCharacter = '\u0000'; // Default null character
        }
    }

    public List<Token> makeTokens() {
        List<Token> tokens = new ArrayList<>();

        while (currentCharacter != '\u0000') {
            switch (currentCharacter) {

                // checking whitespace characters
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    advance(); // skip whitespace characters
                    break;

                // checking digits
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    tokens.add(makeNumber());

                // checking for characters which will make keywords
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    tokens.add(makeLexeme());

                // checking capital letters which won't be allowed
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':



            }
        }

        return tokens;
    }

    // CONSTANT FOR PARSING NUMBERS
    String DIGITS = "0123456789";

    /** Generates a number from a given input of digits */
    public Token makeNumber() {
        StringBuilder number = new StringBuilder(); // check to see if possible to parse into int at end
        int decimalCount = 0;

        // While the current character is not null, and is also a digit
        while (currentCharacter != '\u0000' && DIGITS.contains(Character.toString(currentCharacter))) {
            if (currentCharacter == '.') {

                // if the number already has a decimal, break out, since there cannot be more than one
                if (decimalCount == 1)
                    break;

                decimalCount += 1;
                number.append(".");
            }
            else {
                number.append(currentCharacter);
            }
        }

        // Return either type int or type double (float)
        if (decimalCount == 1) {
            return new Token(TokenType.FLOAT, Double.parseDouble(number.toString()));
        }
        else {
            return new Token(TokenType.INTEGER, Integer.parseInt(number.toString()));
        }
    }

    // CONSTANTS FOR FINDING KEYWORDS
    String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    // arithmetic
    String addition = "add";
    String subtraction = "minus";
    String multiplication = "timez";
    String division = "divid";

    // variable instantiation
    String initializeVariable = "bekom";

    /** Generates a keyword from a given input of characters */
    public Token makeLexeme() {
        StringBuilder lexeme = new StringBuilder(); // compare to keywords above at the end

        // While the current character is not null
        while (currentCharacter != '\u0000') {

        }
    }
}
