package main;

import java.util.Scanner;
import static java.lang.System.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Generator {

    public static void main(String[] args) {
        Scanner input = new Scanner(in);
        Pattern num = Pattern.compile("[0-9]+");
        out.println("Hello, this is your everyday, everyman random number generator!\nLet's get started!");
        while (true) {
            out.print("Pick a number range (no less than 0, no greater than 1,000,000; ex. 1-25): ");
            String range = input.nextLine();
            Matcher matcher = num.matcher(range);
            int a=0;
            int b=0;
            if (matcher.find())
                a = Integer.parseInt(range.substring( matcher.toMatchResult().start(),matcher.toMatchResult().end() ));
            if (matcher.find())
                b = Integer.parseInt(range.substring( matcher.toMatchResult().start(),matcher.toMatchResult().end() ));
            out.printf("Computing...\n");
            int rand = (int)(Math.random()*(b-a)) + a;
            out.printf("You got %d\nAsk again? (Y/n) ", rand);
            if (input.nextLine().toLowerCase().contains("n")) break;
            out.print("Same range? ");
        }
    }
}
