package Lexer;

import Error.*;
import Lexer.Token.Token;


public class TokenErrorPair {
    private final Token token;
    private final Error.Error error;


    public TokenErrorPair(Token token, Error.Error error) {
        this.token = token;
        this.error = error;
    }

    public Token getToken() { return token; }
    public Error.Error getError() { return error; }
}