package Shell;

import Interpreter.Interpreter;
import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("DogeSpeak > ");
            String input = scn.nextLine();
            if (input.equalsIgnoreCase("bai")) {
                System.out.println("wow very concern...bai");
                System.exit(0);
            }
            Interpreter.run(input);
        }
    }
}
