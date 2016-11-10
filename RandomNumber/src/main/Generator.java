package main;

import java.util.Scanner;
import static java.lang.System.*;

public class Generator {

    public static void main(String[] args) {
        Scanner input = new Scanner(in);
        do {
            out.println("Hello, this is your everyday, everyman random number generator!\nLet's get started!");
            out.print("Pick a number range (no less than 0, no greater than 1,000,000; ex. 1-25): ");
            int a = input.nextInt(); int b = input.nextInt(); input.nextLine();
            out.println("Computing...");
            int rand = (int)(Math.random()*b) + a;
            out.printf("You got %d\nAsk again? (Y/n) ", rand);
            if (input.nextLine().toLowerCase().contains("n")) break;
        } while(true);
    }
}
