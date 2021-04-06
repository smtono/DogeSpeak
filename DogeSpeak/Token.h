/**
	Contains the declaration of the Token class

	Based on code found at https://gist.github.com/arrieta/1a309138689e09375b90b3b1aa768e20

	@file Token.h
	@author Shannon Thornton
	@version 1.0
*/

#include <string>
using std::string;

class Token {
public:
	enum class TokenType {
		COMMENT,
        NUMBER,
		IDENTIFIER,
		LEFT_PARENTHESIS,
		RIGHT_PARENTHESIS,
		EQUAL,
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE,
		UNEXPECTED,
		NONE,
	};
	
	Token(TokenType type);


private:
	TokenType token_type = TokenType::NONE;

	bool isSpace();
	bool isDigit();
	bool isChar();
	
};