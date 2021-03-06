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

        // Menu and Display object initialization
        Menu menu = new Menu();
        DebtCalculator calculateDebt = new DebtCalculator();
        User currentUser = new User();
        DisplayScoreAndRank displayScoreAndRank = DisplayScoreAndRank.getInstance();
        DisplayResults displayResults = DisplayResults.getInstance();

        // Initialize budget as member of currentUser
        Budget budget = new Budget();
        currentUser.setBudget(new Budget());

        // Boolean to prevent user from proceeding to main menu
        // unless properly loaded profile from database
        boolean successfulLoad = false;

        /**
         * Intro Menu
         */
        while(successfulLoad == false) {
            while (menu.getOption() != 3) {
                menu.showIntroOptions();
                menu.selectIntroOption();

                //Create New User Profile
                if (menu.getOption() == 1) {
                    CreateUserProfile create = new CreateUserProfile();
                    file.saveFile(create.createUser());
                }
                //Load User Profile
                if (menu.getOption() == 2) {
                    LoadUserProfile load = new LoadUserProfile();
                    currentUser = load.loadUser(file.loadFile());

                    // User properly loaded - allow loop to break

                    if (currentUser.getEmail().equals("failedToLoad")) {
                        // Failed to load - continue to loop
                    } else {
                        successfulLoad = true;
                    }
                    break;
                }
                //Exiting Application
                if (menu.getOption() == 3) {
                    System.exit(0);
                }
            }
        }
        /**
         * Main Menu
         */


        while (menu.getOption() != 16)
        {
            // Update user save
            file.saveFile(currentUser);

            // Display User Score and Rank
            DisplayScoreAndRank.outputScoreAndRank(currentUser);

            // Display menu and receive user selection
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
                DisplayGoals goalDisplay = new DisplayGoals();
                goalDisplay.displayGoals(currentUser);
            }
            //Calculate Goals vs Performance
            if(menu.getOption() == 6)
            {
                CalculateGoalsVsPerformance calculateGoalsVsPerformance = new CalculateGoalsVsPerformance();
                calculateGoalsVsPerformance.PerformanceAnalysis(currentUser);
            }
            //Set Budget
            if(menu.getOption() == 7)
            {
                BudgetReminder budgetReminder = new BudgetReminder(currentUser.getSaveAmount());
                budgetReminder.setSpendGoal(currentUser.getSpendAmount());

                budget.setBudgetReminder(budgetReminder);
                budget.CreateBudget(currentUser);
                currentUser.setBudget(budget);
            }
            // Add to budget
            if(menu.getOption() == 8){
                currentUser.budget.AddToBudget(currentUser);
            }
            // Remove from budget
            if(menu.getOption() == 9){
                currentUser.budget.RemoveFromBudget();
            }
            //Update Profile
            if(menu.getOption() == 10)
            {
                UpdateProfile updateProfile = new UpdateProfile();
                updateProfile.updateInfo(currentUser);
            }
            // Progress to Next Week
            if (menu.getOption() == 11){

                // Save week ending as previous week
                currentUser.getPreviousWeek().toNextWeek(currentUser);

                // Update User Score and Rank
                //currentUser.calculateScore();
                //currentUser.calculateRank();

            }
            // Display Results (Current, Previous, Initial Weeks)
            if(menu.getOption() == 12){
                displayResults.outputResults(currentUser);
            }
            // Display Report
            if(menu.getOption() == 13){
                CreateReport createReport = new CreateReport();
                createReport.showReport(currentUser);
            }
            // Send Report to Email
            if(menu.getOption() == 14){
                SendEmail sendEmail = new SendEmail();
                sendEmail.sendEmail(currentUser);
            }
            // Send Report to Text
            if(menu.getOption() == 15){
                ReportToText reportToText = new ReportToText();
                reportToText.printInfoToFile(currentUser);
            }
            // Exit Application
            if (menu.getOption() == 16){
                file.saveFile(currentUser);
            }
        }
    }
}