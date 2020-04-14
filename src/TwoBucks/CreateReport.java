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

package TwoBucks;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class CreateReport {


    /**
     * @param currentUser
     * @return contents which is an array that will contain the information for the report contents
     */
    public String[] reportContents(User currentUser){

        DecimalFormat df = new DecimalFormat("0.00");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


        String title = ("******** TwoBucks User Profile Data Report *********");
        String space = (" ");
        String date = (dateFormatter.format(now));
        String name =  ("Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
        String email = ("Email: " + currentUser.getEmail());
        String income = ("Weekly Income: "+ currentUser.getIncome());
        String spendingGoal = ("Spending goal for this week: "+ currentUser.getSpendAmount());
        String expenses = ("Your expenses this week: " + currentUser.getExpenses());
        String savingGoal = ("Your savings this week: "+ (currentUser.getIncome() - currentUser.getExpenses()));
        String savings = ("Your savings this week: "+ (currentUser.getIncome() - currentUser.getExpenses()));
        String budgetTitle = ("Budget for this week: ");
        String rent = ("    - Rent: "+ currentUser.getBudget().getRentExpenses());
        String utilities = ("    - Utilities: "+ currentUser.getBudget().getUtilitiesExpenses());
        String food = ("    - Food: "+ currentUser.getBudget().getFoodExpenses());
        String travel = ("    - Travel: "+ currentUser.getBudget().getTravelExpenses());
        String healthcare = ("    - Healthcare: "+ currentUser.getBudget().getHealthcareExpenses());
        String entertainment = ("    - Entertainment: "+ currentUser.getBudget().getEntertainmentExpenses());

        String[] contents = {title,space,date,space,name,email,income,spendingGoal,expenses,savingGoal,savings,budgetTitle,rent,utilities,food,travel,healthcare,entertainment};

        return contents;
    }

    /**
     * This method will output a report of the User's full profile and analysis
     *
     * @param currentUser
     */

    public void showReport(User currentUser){

        String[] reportInfo = reportContents(currentUser);

        for (String element:reportInfo){
            System.out.println(element);
        }

    }

}
