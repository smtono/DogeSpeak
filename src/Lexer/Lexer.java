package Lexer;

import Lexer.Token.*;

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

    // HELPER METHODS
    /** Goes to the next character in the text */
    private void advance() {
        currentPosition += 1;
        if (this.currentPosition < text.length()) {
            this.currentCharacter = text.charAt(currentPosition);
        }
        else {
            this.currentCharacter = 0; // Default null character
        }
    }

    List<Token> tokens = new ArrayList<>();

    // TODO: make this return a list of TokenErrorPair(s)
    public List<Token> makeTokens() {
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

                // SHANNON TODO: update for checking errors
                default:
                    char c = currentCharacter;
                    advance();
                    return new ArrayList<>();
            }
        }

        return tokens;
    }

    // CONSTANT FOR PARSING NUMBERS
    String DIGITS = "0123456789";

    // TODO: return a TokenErrorPair
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

        // TODO: Check for letters/other characters, append error to token
        /*
                if (currentCharacter == 0) {
                    check if integer or float (see code below)
                    return the pair with no error
                }
                else {
                    return token and invalid character error
                }
         */
        
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
            "bekom",
            "wen", "and", "or", "not",  "iz",// control flow
            "quite!!", "!!"); // comments
    List<String> arithmeticOperations = Arrays.asList(
            "add", "sub", "timez", "divid"// arithmetic
    );
    //List<String> controlFlow = Arrays.asList(
    //      ""
    //)


    // TODO: return TokenErrorPair
    // TODO: break up this method into two parts where one deals with finding the actual token, and the other with the keyword
    /** Generates a keyword from a given input of characters */
    public Token makeLexeme() {
        StringBuilder lexeme = new StringBuilder(); // compare to keywords above at the end

        // While the current character is not null
        while (currentCharacter != 0) {
            if (DIGITS.contains(Character.toString(currentCharacter))) {
                makeNumber();
            }

            switch (currentCharacter) {
                // White space will be the terminator character
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                    advance();
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
                    advance();
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

                default:
                    break;

            }
        }

        List<TokenType> tokens = Arrays.asList(TokenType.values());
        List<ArithmeticOperation> arithmeticOperationsTokens = Arrays.asList(ArithmeticOperation.values());

        /*
            private Token method()
            
            To get lexeme from StringBuilder: lexeme.toString();
        // We are checking the lexeme against the values in the specific list
            method(List<> keywordList, String lexeme) {
                simplify the for loop
            }
         */
        // TODO: simplify this mess （；´д｀）ゞ
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
        else if (arithmeticOperations.contains(lexeme.toString())) { // if the lexeme is a keyword, then it will be that keyword
            for(int i = 0; i < arithmeticOperations.size(); i++) { // iterating through all keywords in the list
                if (arithmeticOperations.get(i).equals(lexeme.toString())) { // if a keyword matches the lexeme then we get that token
                    for(int j = 0; j < arithmeticOperationsTokens.size(); j++) { // iterate through all the tokens
                        if (arithmeticOperations.get(i).equals(arithmeticOperationsTokens.get(j).getKeyword())) { // if the keyword equals the matching token, return that token
                            return new Token(TokenType.OPERATOR, arithmeticOperationsTokens.get(j)); // return that token
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

    // Don't worry about this for now -> TODO: make a defined Pair class where we can return both Tokens AND Errors (errors not implemented yet)
    /** Runs the tokenizer on the text input */
    public static List<Token> run(String code) {
        Lexer lexer = new Lexer(code);

        List<Token> tokens = lexer.makeTokens();
        StringBuilder output = new StringBuilder();

        // Don't worry about this -> TODO: Fix the output of this. Why does it go to the next line???
        output.append("(");
        tokens.forEach(token -> {
            if (token.getValue() != null) {
                output.append(token).append(", ");
            }
            else {
                output.append(token.getType()).append(", ");
            }
        });
        output.append(")");
        return tokens;
    }
    
    /*
    // TODO: add "No Error" error
    public static List<TokenErrorPair> tokenize(String code) {
        Lexer lexer = new Lexer(code);
        
        
    }
    */
}
