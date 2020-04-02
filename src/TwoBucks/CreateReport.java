/**
 * Create Organized Report Feature US.4
 *
 * The CreateReport class is used when the user chooses to
 * view a report that contains their saved information on their profile,
 * their performance, goals, along with their personal information. It gives
 * the user a full overview of everything that deals with the program.
 *
 * @author Frino Jais
 * @version 1.0
 * @since 04-01-2020
 */


import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CreateReport {

    /**
     * This method will output a report of the User's full profile and analysis
     *
     * @param currentUser
     */
    public void showReport(User currentUser){

        DecimalFormat df = new DecimalFormat("0.00");

        Budget userBudget;

        System.out.println("******** TwoBucks User Profile Data Report *********");
        System.out.println("");
        System.out.println("Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Weekly Income: "+ currentUser.getIncome());
        System.out.println("Spending goal for this week: "+ currentUser.getSpendAmount());
        System.out.println("Your expenses this week: " + currentUser.getExpenses());
        System.out.println("Saving goal for this week: "+ currentUser.getSaveAmount());
        System.out.println("Your savings this week: "+ (currentUser.getIncome() - currentUser.getExpenses()));
        System.out.println("Budget for this week: ");
        System.out.println("    - Rent: "+ currentUser.getBudget().getRentExpenses());
        System.out.println("    - Utilities: "+ currentUser.getBudget().getUtilitiesExpenses());
        System.out.println("    - Food: "+ currentUser.getBudget().getFoodExpenses());
        System.out.println("    - Travel: "+ currentUser.getBudget().getTravelExpenses());
        System.out.println("    - Healthcare: "+ currentUser.getBudget().getHealthcareExpenses());
        System.out.println("    - Entertainment: "+ currentUser.getBudget().getEntertainmentExpenses());



    }

}
