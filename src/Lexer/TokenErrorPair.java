package Lexer;

import Error.*;
import Lexer.Token.Token;


public class TokenErrorPair {
    private final Token token;
    private final GenericError error;


    public TokenErrorPair(Token token, GenericError error) {
        this.token = token;
        this.error = error;
    }

    public Token getToken() { return token; }
    public GenericError getError() { return error; }
}