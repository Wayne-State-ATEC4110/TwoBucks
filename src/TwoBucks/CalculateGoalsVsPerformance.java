/**
 * Calculate Goals vs. Actual Performance US.10
 *
 * The CalculateGoalsVsPerformance class is used when the user wants
 * to view their statistics of their performance compared to their
 * set goals. It will follow the pipe and filter architecture because
 * it uses data from other portions of the program, and outputs information
 * based on that data
 *
 * @author Frino Jais
 * @version 1.0
 * @since 03-04-2020
 */
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.*;

public class CalculateGoalsVsPerformance {

    private static DecimalFormat df = new DecimalFormat("0.00"); // to keep the values in the correct format

    /***
     * This function will take the data from other classes to show results of how the
     * user has been spending/saving.
     */
    public void PerformanceAnalysis() { // function to show statistics of spending/saving vs actual

        EnterFinancialGoals goals = new EnterFinancialGoals(); // creating an object to retrieve user's goals
        EnterWeeklyExpense expense = new EnterWeeklyExpense(); //  creating object to retrieve user's expenses
        EnterWeeklyIncome income = new EnterWeeklyIncome(); // creating object to retrieve user's income

        double weeklySavings = (expense.setUserExpenses() - income.enterIncome()); // calculating savings

        System.out.println("Your spending goal for this week was "+ goals.enterSpendGoal()+".");
        System.out.println("You spent "+ expense.setUserExpenses()+ " this week.");
        System.out.println(" ");

        if (goals.enterSpendGoal() < expense.setUserExpenses()){
            System.out.println("You have exceeded your spending goals by " + (expense.setUserExpenses() - goals.enterSpendGoal())+".");

        }else if (goals.enterSpendGoal() == expense.setUserExpenses()){
            System.out.println("Congratulations! You have exactly met your spending goal.");

        }else{
            System.out.println("Congratulations! You have spent less than spending goal. "+ (goals.enterSpendGoal() - expense.setUserExpenses())+" in savings!");

        }

        System.out.println(" ");
        System.out.println("Your saving goal for this week was "+ goals.enterSaveGoal()+".");
        System.out.println("You saved "+ (income.enterIncome() - expense.setUserExpenses())+".");
        System.out.println(" ");

        if (goals.enterSaveGoal() < weeklySavings){
            System.out.println("Congratulations! You have saved " + (weeklySavings - goals.enterSaveGoal())+" more than your saving goal.");

        }else if (goals.enterSaveGoal() == weeklySavings){
            System.out.println("Congratulations! You have exactly met your saving goal.");

        }else{
            System.out.println("You have missed your saving goal by "+ (goals.enterSaveGoal() - weeklySavings)+".");

        }





    }
}
