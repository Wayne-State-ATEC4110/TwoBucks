package TwoBucks;

import java.util.Scanner;

public class EnterWeeklyExpense
{
    private double expenses;

    public double getExpenses()
    {
        return this.expenses;
    }

    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }

    public void setUserExpenses()
    {
        Scanner scanner = new Scanner(System.in);
        double userExpenses;
        System.out.println("Enter your weekly expenses: ");
        userExpenses = scanner.nextDouble();
        setExpenses(userExpenses);
    }
}
