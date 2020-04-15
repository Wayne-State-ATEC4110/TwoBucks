package TwoBucks;

import org.junit.Test;

import static org.junit.Assert.*;

public class BudgetReminderTest {

    @Test
    public void budgetAddReminder()
    {
        BudgetReminder budgetReminder = new BudgetReminder();
        User user = new User();
        double testValue = 50;
        double amount = 20;

        if(testValue <= 0)
        {
            System.out.println("Create a financial goal to set up a weekly spending allowance.");
        }
        else
        {
            double goal = testValue - amount;
            System.out.println("Current spendings left: $" + goal);
            System.out.println("Current goal: $" + testValue);
        }
    }

    @Test
    public void budgetRemoveReminder()
    {
        BudgetReminder budgetReminder = new BudgetReminder();
        User user = new User();
        double testValue = 50;
        double amount = 20;

        if(testValue <= 0)
        {
            System.out.println("Create a financial goal to set up a weekly spending allowance.");
        }
        else
        {
            double goal = testValue + amount;
            System.out.println("Current spendings left: $" + goal);
            System.out.println("Current goal: $" + testValue);
        }
    }

    @Test
    public void setSpendGoal()
    {
    }
}