package Shell;

import Parser.Parser;

import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("DogeSpeak > ");
            String input = scn.nextLine();
            Parser.run(input);
        }
    }
}
