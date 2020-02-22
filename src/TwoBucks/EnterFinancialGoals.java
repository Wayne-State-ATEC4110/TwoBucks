package TwoBucks;

// Two Bucks
// US7. Enter Financial Goals
// By Frino Jais

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.*;

public class EnterFinancialGoals {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public double enterSpendGoal() {
        double spendAmt;

        Scanner in = new Scanner(System.in);

        System.out.println("How much would you like to spend per week?");
        while (true) {
            try {
                spendAmt = Double.parseDouble(in.nextLine());
                if (spendAmt < 0) {
                    System.out.println("Please enter a value of 0 or higher.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a numerical value.");
            }
        }
        System.out.println("Spending amount of $" + df.format(spendAmt) + " has been saved to your user profile!");
        return spendAmt;
        }

    public double enterSaveGoal(){

        Scanner in = new Scanner(System.in);

        double saveAmt;

        System.out.println("\nHow much would you like to save per week?");
        while (true) {
            try {
                saveAmt = Double.parseDouble(in.nextLine());
                if (saveAmt < 0) {
                    System.out.println("Please enter a value of 0 or higher.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a numerical value.");
            }
        }
        System.out.println("Saving amount of $" + df.format(saveAmt) + " has been saved to your user profile!");
        return saveAmt;
    }
}
