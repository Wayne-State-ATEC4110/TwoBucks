package TwoBucks;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author  Sawyer Kisha
 * @version 1.4
 * @since   1.0
 * Main.java
 */
public class Main
{
    public static void main(String[] args)throws IOException
    {
        //Save user
        FileManagement file = new FileManagement();

        Menu menu = new Menu();
        DebtCalculator calculateDebt = new DebtCalculator();

        /**
         * Intro Menu
         */
        menu.showIntroOptions();
        menu.selectIntroOption();

        //Create New User Profile
        if (menu.getOption() == 1)
        {
            CreateUserProfile create = new CreateUserProfile();
            file.saveFile(create.createUser());
        }
        //Load User Profile
        if (menu.getOption() == 2)
        {
            LoadUserProfile load = new LoadUserProfile();
            User currentUser = load.loadUser(file.loadFile());
        }
        //Exiting Application
        if (menu.getOption() == 3)
        {
            System.exit(0);
        }

        /**
         * Main Menu
         */
        while (menu.getOption() != 8)
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
            //Display Goals
            if(menu.getOption() == 5)
            {
                User user = new User();
                DisplayGoals goalDisplay = new DisplayGoals();
                goalDisplay.displayGoals(user);
            }
            //Budget
            if(menu.getOption() == 6)
            {
                while(menu.getOption() != 4)
                {
                    menu.showBudgetOptions();
                    menu.selectBudgetOption();

                    Budget budget = new Budget();

                    if (menu.getOption() == 1)
                    {
                        try
                        {
                            Method method = Budget.class.getDeclaredMethod("DisplayBudget");
                            method.setAccessible(true);
                            method.invoke(budget);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    if (menu.getOption() == 2) {
                        budget.AddToBudget();
                    }
                    if (menu.getOption() == 3) {
                        budget.RemoveFromBudget();
                    }
                }
            }
            //Update Profile
            if(menu.getOption() == 7)
            {
                User user = new User();
                UpdateProfile updateProfile = new UpdateProfile();
                updateProfile.updateInfo(user);
            }
            if (menu.getOption() == 8){
               file.saveFile(currentUser);
            }

            //Create more paths for future features...
        }
    }
}