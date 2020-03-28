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


package TwoBucks;

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
    public void PerformanceAnalysis(User currentUser) { // function to show statistics of spending/saving vs actual

        double weeklySavings = (currentUser.getIncome() - currentUser.getExpenses()); // calculating savings

        System.out.println("Your spending goal for this week was "+ currentUser.getSpendAmount()+".");
        System.out.println("You spent "+ currentUser.getExpenses()+ " this week.");
        System.out.println(" ");

        if (currentUser.getSpendAmount() < currentUser.getExpenses()){
            System.out.println("You have exceeded your spending goals by " + (currentUser.getExpenses() - currentUser.getSpendAmount())+".");

        }else if (currentUser.getSpendAmount() == currentUser.getExpenses()){
            System.out.println("Congratulations! You have exactly met your spending goal.");

        }else{
            System.out.println("Congratulations! You have spent less than spending goal. "+ (currentUser.getSpendAmount() - currentUser.getExpenses())+" in savings!");

        }

        System.out.println(" ");
        System.out.println("Your saving goal for this week was "+ currentUser.getSaveAmount()+".");

        System.out.println("You saved "+ (currentUser.getIncome() - currentUser.getExpenses())+".");

        System.out.println("You saved "+ (currentUser.getIncome() - currentUser.getExpenses()+"."));

        System.out.println(" ");

        if (currentUser.getSaveAmount() < weeklySavings){
            System.out.println("Congratulations! You have saved " + (weeklySavings - currentUser.getSaveAmount())+" more than your saving goal.");

        }else if (currentUser.getSaveAmount() == weeklySavings){
            System.out.println("Congratulations! You have exactly met your saving goal.");

        }else{
            System.out.println("You have missed your saving goal by "+ (currentUser.getSaveAmount() - weeklySavings)+".");

        }





    }
}
