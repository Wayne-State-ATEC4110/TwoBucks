
/**
 * <h1>Main</h1>
 *
 * <p>The Main class calls the projects
 * functions and sends the user to their
 * designated feature</p>
 *
 * @author  Sawyer Kisha
 * @version 1.5
 * @since   1.0
 */

package TwoBucks;

        import java.io.IOException;
        import java.lang.reflect.Method;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        //Save user
        FileManagement file = new FileManagement();

        Menu menu = new Menu();
        DebtCalculator calculateDebt = new DebtCalculator();
        User currentUser = new User();

        // Initialize budget as member of currentUser
        Budget budget = new Budget();
        currentUser.setBudget(new Budget());

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
            currentUser = load.loadUser(file.loadFile());
        }
        //Exiting Application
        if (menu.getOption() == 3)
        {
            System.exit(0);
        }

        /**
         * Main Menu
         */
        while (menu.getOption() != 10)
        {
            menu.showOptions();
            menu.selectOption();

            //User user = new User();

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
                DisplayGoals goalDisplay = new DisplayGoals();
                goalDisplay.displayGoals(currentUser);
            }
            //Calculate Goals vs Performance
            if(menu.getOption() == 6)
            {
                CalculateGoalsVsPerformance calculateGoalsVsPerformance = new CalculateGoalsVsPerformance();
                calculateGoalsVsPerformance.PerformanceAnalysis(currentUser);
            }
            //Budget
            if(menu.getOption() == 7)
            {
                BudgetReminder budgetReminder = new BudgetReminder();
                budgetReminder.setSpendGoal(currentUser.getSpendAmount());

                budget.setBudgetReminder(budgetReminder);
                budget.CreateBudget();
                currentUser.setBudget(budget);
            }
            //Update Profile
            if(menu.getOption() == 8)
            {
                UpdateProfile updateProfile = new UpdateProfile();
                updateProfile.updateInfo(currentUser);
            }
            if (menu.getOption() == 9){
                Week week = new Week();
                currentUser.setWeek(week);
                currentUser= currentUser.getWeek().toNextWeek(currentUser);

            }
            if (menu.getOption() == 10){
                file.saveFile(currentUser);
            }

            //Create more paths for future features...
        }
    }

}