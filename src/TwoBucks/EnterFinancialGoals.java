package TwoBucks;

// Two Bucks
// US7. Enter Financial Goals
// By Frino Jais

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class EnterFinancialGoals {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static float readFloat(Scanner reader) {
        float num;
        while (true) {
            try {
                num = Float.parseFloat(reader.nextLine());
                return num;
            } catch (Exception e) {
                System.out.println("Please enter a numerical value.");
            }
        }
    }

    public static void main(String args[]) {

        float saveAmt;
        float spendAmt;

        Scanner in = new Scanner(System.in);

        System.out.println("How much would you like to spend per week?");

        spendAmt = readFloat(in);

        while (spendAmt < 0) {
            System.out.println("Please enter a value of 0 or higher.");

            spendAmt = readFloat(in);
        }
        System.out.println("Spending amount of $" + df.format(spendAmt) + " has been saved to your user profile!");
        System.out.println(" ");
        System.out.println("How much would you like to save per week?");

        saveAmt = readFloat(in);

        while (saveAmt < 0) {
            System.out.println("Please enter a value of 0 or higher.");
            saveAmt = readFloat(in);
        }
        System.out.println("Saving amount of $" + df.format(saveAmt) + " has been saved to your user profile!");
    }
}
