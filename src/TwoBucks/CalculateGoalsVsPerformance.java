// Two Bucks
// US10. Calculate Goals vs Actual Performance
// By Frino Jais

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.*;

public class CalculateGoalsVsPerformance {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public void PerformanceAnalysis() {

        EnterFinancialGoals goals = new EnterFinancialGoals();
        EnterWeeklyExpense expense = new EnterWeeklyExpense();
        EnterWeeklyIncome income = new EnterWeeklyIncome();

        double weeklySavings = (expense.setUserExpenses() - income.enterIncome());

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
