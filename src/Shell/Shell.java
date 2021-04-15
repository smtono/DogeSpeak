package Shell;

import Lexer.Lexer;

import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("DogeSpeak > ");
            String input = scn.next();
            //System.out.print(input + "\n");
            Lexer.tokenize(input);
        }
    }
}
