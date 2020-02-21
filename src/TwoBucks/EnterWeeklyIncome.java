package TwoBucks;

// Two Bucks
// US8. Enter Weekly Income
// By Frino Jais

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class EnterWeeklyIncome {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void enterIncome() {

        float weeklyIncome;

        Scanner in = new Scanner(System.in);

        System.out.println("What is you weekly income?");
        while (true) {
            try {
                weeklyIncome = Float.parseFloat(in.nextLine());
                if (weeklyIncome < 0) {
                    System.out.println("Please enter a value of 0 or higher.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a numerical value.");
            }
        }

        System.out.println("Weekly income of $" + df.format(weeklyIncome) + " has been saved to your user profile!");
    }
}