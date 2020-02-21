package TwoBucks;

// Two Bucks
// By Sawyer Kisha

public class Main
{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        EnterWeeklyExpense enterWeeklyExpense = new EnterWeeklyExpense();

        while (menu.getOption() != 5)
        {
            menu.showOptions();
            menu.selectOption();

            //Enter Weekly Income
            if (menu.getOption() == 1)
            {
                //Send to EnterWeeklyIncome
            }
            //Enter Weekly Expense
            if (menu.getOption() == 2)
            {
                enterWeeklyExpense.setUserExpenses();
            }
            //Enter Financial Goals
            if (menu.getOption() == 3)
            {
                //Send to EnterFinancialGoals
            }

            //Create more paths for future features...
        }
    }
}
