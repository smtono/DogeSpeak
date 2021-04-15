package Lexer;

import java.util.ArrayList;
import java.util.Arrays;
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
        currentCharacter = 0; // Default null character
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
            this.currentCharacter = 0; // Default null character
        }
    }

    public List<Token> makeTokens() {
        List<Token> tokens = new ArrayList<>();

        while (currentCharacter != 0) {
            switch (currentCharacter) {

                // TODO: Fix DRY code (this code repeats in makeLexeme()
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
                    break;

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
                    break;

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
                    System.out.println("pls nao yellingg!!");
                    break;


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
        while (currentCharacter != 0 && DIGITS.contains(Character.toString(currentCharacter))) {
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

            advance();
        }

        // TODO: IMPLEMENT AN ERROR FOR ADDING A LETTER
        // Return either type int or type double (float)
        if (decimalCount == 1) {
            return new Token(TokenType.FLOAT, Double.parseDouble(number.toString()));
        }
        else {
            return new Token(TokenType.INTEGER, Integer.parseInt(number.toString()));
        }
    }

    // CONSTANTS FOR FINDING KEYWORDS
    // TODO: SPLIT INTO EVEN MORE SPECIFIC KEYWORDS (operator, control flow, etc)
    List<String> keywords = Arrays.asList(
            "add", "sub", "timez", "divid", "equel", // arithmetic
            "bekom",
            "if", "and", "or", "not", // control flow
            "quite!!", "!!"); // comments


    // TODO: break up this method into two parts where one deals with finding the actual token, and the other with the keyword
    /** Generates a keyword from a given input of characters */
    public Token makeLexeme() {
        StringBuilder lexeme = new StringBuilder(); // compare to keywords above at the end

        // While the current character is not null
        while (currentCharacter != 0) {
            switch (currentCharacter) {
                // White space will be the terminator character
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    break;

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
                    System.out.println("pls nao yellingg!!");
                    break;

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
                    lexeme.append(currentCharacter);
                    advance();
                    break;
            }
        }

        // TODO: check for operators and have that be the token
        List<TokenType> tokens = Arrays.asList(TokenType.values());
        // TODO: simplify this mess
        if (keywords.contains(lexeme.toString())) { // if the lexeme is a keyword, then it will be that keyword
            for(int i = 0; i < keywords.size(); i++) { // iterating through all keywords in the list
                if (keywords.get(i).equals(lexeme.toString())) { // if a keyword matches the lexeme then we get that token
                    for(int j = 0; j < tokens.size(); j++) { // iterate through all the tokens
                        if (keywords.get(i).equals(tokens.get(j).getKeyword())) { // if the keyword equals the matching token, return that token
                            return new Token(tokens.get(j)); // return that token
                        }
                    }
                }
            }
        }
        else { // else, it must be an identifier.
            return new Token(TokenType.IDENTIFIER, lexeme.toString());
        }
        // if none of the above happened, it is an unexpected value
        return new Token(TokenType.UNEXPECTED);
    }

    // TODO: make a defined Pair class where we can return both Tokens AND Errors (errors not implemented yet)
    /** Runs the tokenizer on the text input */
    public static List<Token> tokenize(String code) {
        Lexer lexer = new Lexer(code);

        List<Token> tokens = lexer.makeTokens();
        StringBuilder output = new StringBuilder();

        // TODO: fix this so it prints like -> [(INTEGER: 1, OPERATOR: ADD, INTEGER: 1)]
        tokens.forEach(token -> {
            output.append("[" + token.getType() + "] ");
            if (token.getValue() != null) {
                output.append(token.getValue());
            }
        });

        System.out.println(output);

        return tokens;
    }
}
