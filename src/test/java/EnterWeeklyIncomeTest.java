import org.junit.Test;

import static org.junit.Assert.*;

public class EnterWeeklyIncomeTest {

    @Test
    public void enterIncome() {
        double testValues[];
        testValues = new double[4];

        testValues[0]=-5.8;
        testValues[1]=-0.001;
        testValues[2]=-95;
        testValues[3]=8;

        int i=0;

        System.out.println("What is your weekly income?");
        do {
            double input = testValues[i];

            try {
                if (input < 0) {
                    System.out.println(testValues[i]);
                    System.out.println("Please enter a value of 0 or higher.");
                    i++;
                } else {
                    System.out.println(testValues[i]);
                    System.out.println("Weekly Income of $" + testValues[i] + " has been saved to your user profile!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a numerical value.");
                i++;
            }


        }while(i < testValues.length);

    }
}