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

package TwoBucks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ReportToText {


    /**
     * This method will output the user report generated in the CreateReport class to a txt file.
     * This txt file will also include a time stamp so the user knows when the report is from
     * if they have multiple reports saved.
     * @param currentUser
     */
    void printInfoToFile(User currentUser) {

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis); // Using a different time stamp than CreateReport.java because txt files cannot be saved using characters like '/'

        String[] reportInfo = CreateReport.reportContents(currentUser); // creating an object for the report data for the current user



        File file = new File(currentUser.getFirstName()+" "+currentUser.getLastName()+" TwoBucks User Report "+ date+".txt"); //reading data from this file
        try {
            PrintWriter write = new PrintWriter(file);

            for (String element:reportInfo){ // for loop to write to the txt file
                write.println(element);
            }

            write.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}