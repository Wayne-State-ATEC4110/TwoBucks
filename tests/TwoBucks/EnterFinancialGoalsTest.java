import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

// tests using the logic of the EnterFinancialGoals class because user input is required

public class EnterFinancialGoalsTest {

    @Test
    public void enterSpendGoal() {

        double testValues[];
        testValues = new double[4];

        testValues[0]=-7.2;
        testValues[1]=-0.1;
        testValues[2]=-87;
        testValues[3]=500;

        int i=0;

        System.out.println("How much would you like to spend per week?");
        do {
                double input = testValues[i];

                try {
                    if (input < 0) {
                        System.out.println(testValues[i]);
                        System.out.println("Please enter a value of 0 or higher.");
                        i++;
                    } else {
                        System.out.println(testValues[i]);
                        System.out.println("Spending amount of $" + testValues[i] + " has been saved to your user profile!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a numerical value.");
                    i++;
                }


            }while(i < testValues.length);



    }

    @Test
    public void enterSaveGoal() {

        double testValues[];
        testValues = new double[4];

        testValues[0]=-7.2;
        testValues[1]=-500;
        testValues[2]=-87;
        testValues[3]=0.0001;

        int i=0;

        System.out.println("How much would you like to save per week?");
        do {
            double input = testValues[i];

            try {
                if (input < 0) {
                    System.out.println(testValues[i]);
                    System.out.println("Please enter a value of 0 or higher.");
                    i++;
                } else {
                    System.out.println(testValues[i]);
                    System.out.println("Saving amount of $" + testValues[i] + " has been saved to your user profile!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a numerical value.");
                i++;
            }


        }while(i < testValues.length);

    }
}