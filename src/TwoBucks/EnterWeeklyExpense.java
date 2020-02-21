package TwoBucks;

// Two Bucks
// US9. Enter Weekly Expense
// By Sawyer Kisha

import java.util.Scanner;

public class EnterWeeklyExpense
{
    public void setUserExpenses()
    {
        //Inputting the weekly expense
        Scanner scanner = new Scanner(System.in);
        double userExpenses;
        System.out.println("Enter your weekly expenses: ");
        userExpenses = scanner.nextDouble();

        //If input is less than 0 prompt for a new input
        while(userExpenses < 0)
        {
            System.out.println("Invalid: expense must be more than 0 ");
            System.out.println("Enter your weekly expenses: ");
            userExpenses = scanner.nextDouble();
        }
        //Sends to user
        setExpenses(userExpenses);
        System.out.println("Weekly expense of $" + userExpenses + " has been saved to your user profile!");
    }
}
