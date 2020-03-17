package TwoBucks;

// Two Bucks
// By Sawyer Kisha

import java.io.IOException;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        //save user
        FileManagement file = new FileManagement();

        //create user profile
        CreateUserProfile create = new CreateUserProfile();
        file.saveFile(create.createUser().toString());

        //load user profile
        LoadUserProfile load = new LoadUserProfile();
        User currentUser = load.loadUser(file.loadFile());

        Menu menu = new Menu();
        DebtCalculator calculateDebt = new DebtCalculator();

        while (menu.getOption() != 5)
        {
            menu.showOptions();
            menu.selectOption();

            //Enter Weekly Income
            if (menu.getOption() == 1)
            {
                EnterWeeklyIncome income = new EnterWeeklyIncome();
                currentUser.setIncome(income.enterIncome());
            }
            //Enter Weekly Expense
            if (menu.getOption() == 2)
            {
                EnterWeeklyExpense enterWeeklyExpense = new EnterWeeklyExpense();
                currentUser.setExpenses(enterWeeklyExpense.setUserExpenses());
            }
            //Enter Financial Goals
            if (menu.getOption() == 3)
            {
                EnterFinancialGoals goals = new EnterFinancialGoals();
                currentUser.setSpendAmount(goals.enterSpendGoal());
                currentUser.setSaveAmount(goals.enterSaveGoal());
            }
            //Debt Calculator
            if (menu.getOption() == 4)
            {
                calculateDebt.DebtCalculatorMain();
            }
            if (menu.getOption()== 5){
                file.saveFile(currentUser.toString());
            }

            //Create more paths for future features...
        }
    }
}
