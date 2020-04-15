package TwoBucks;

import java.util.Scanner;

/**
 * @author  Sawyer Kisha
 * @version 1.3
 * @since   1.0
 * EnterWeeklyExpense.java
 */
public class EnterWeeklyExpense
{
    /**
     * setUserExpenses prompts and gathers
     * the user's weekly expense in the form of
     * a double called userExpenses.
     * @return userExpenses
     */
    public double setUserExpenses()
    {

        Scanner scanner = new Scanner(System.in);

        /**
         * holds the current user's weekly expense
         */
        double userExpenses;

        System.out.println("Enter your weekly expenses: ");
        while(true)
        {
            try
            {
                userExpenses = scanner.nextDouble();
                if (userExpenses < 0)
                {
                    System.out.println("Invalid: expense must be more than 0 ");
                }
                else
                {
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Please enter a numerical value.");
                scanner = new Scanner(System.in);
            }
        }

        System.out.println("Weekly expense of $" + userExpenses + " has been saved to your user profile!");
        return userExpenses;
    }
}