package TwoBucks;

// Two Bucks
// US9. Enter Weekly Expense
// By Sawyer Kisha

import java.util.Scanner;

public class EnterWeeklyExpense
{
    //Taken from user class
    /*
    private double expenses;

    public double getExpenses()
    {
        return this.expenses;
    }

    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }
    */

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
        setExpenses(userExpenses);
    }
}
