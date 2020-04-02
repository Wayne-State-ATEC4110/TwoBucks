/**
 * Create Organized Report Feature US.5
 *
 * The ReportToText class is used when the user chooses to
 * save the report created in the CreateProfile class in a txt file.
 *
 * @author Frino Jais
 * @version 1.0
 * @since 04-01-2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportToText {


    /**
     * This method will output the user report generated in the CreateReport class to a txt file.
     * This txt file will also include a time stamp so the user knows when the report is from
     * if they have multiple reports saved.
     * @param currentUser
     */
    void printInfoToFile(User currentUser) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        File file = new File("TwoBucks User Report.txt"); //reading data from this file
        try {
            PrintWriter write = new PrintWriter(file);
            write.println("******** TwoBucks User Profile Data Report *********");
            write.println(" ");
            write.println("Date: ");
            write.println(dateFormatter.format(now));
            write.println(" ");
            write.println("Name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
            write.println("Email: " + currentUser.getEmail());
            write.println("Weekly Income: "+ currentUser.getIncome());
            write.println("Spending goal for this week: "+ currentUser.getSpendAmount());
            write.println("Your expenses this week: " + currentUser.getExpenses());
            write.println("Saving goal for this week: "+ currentUser.getSaveAmount());
            write.println("Your savings this week: "+ (currentUser.getIncome() - currentUser.getExpenses()));
            write.println("Budget for this week: ");
            write.println("    - Rent: "+ currentUser.getBudget().getRentExpenses());
            write.println("    - Utilities: "+ currentUser.getBudget().getUtilitiesExpenses());
            write.println("    - Food: "+ currentUser.getBudget().getFoodExpenses());
            write.println("    - Travel: "+ currentUser.getBudget().getTravelExpenses());
            write.println("    - Healthcare: "+ currentUser.getBudget().getHealthcareExpenses());
            write.println("    - Entertainment: "+ currentUser.getBudget().getEntertainmentExpenses());
            write.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}