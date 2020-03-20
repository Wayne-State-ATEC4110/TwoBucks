/**
 * Update Profile Feature US.24
 *
 * The UpdateProfile class is used when the user chooses to update
 * their old first name, last name, or email to a new one. It will
 * follow the pipe and filter architecture style because it uses data retrieved
 * from another portions of the program, edits it, and outputs it in
 * its original format
 *
 * @author Frino Jais
 * @version 1.0
 * @since 03-04-2020
 */

import java.util.*;
import java.io.*;

public class UpdateProfile {
    /***
     * This function will read from the text file where the
     * User information is stored and change the user's choice
     * of first name, last name, or email address
     *
     * @param args
     * @throws Exception
     */
    public static void readFile(String[] args) throws Exception{
        // creating object for User.txt where data is saved
        File txtFile = new File("User.txt");
        // reader created to read from User.txt
        BufferedReader reader = new BufferedReader(new FileReader(txtFile));
        String dataRows[][] = new String[100][5]; // creating enough rows for 100 users
        String rowItems[] = new String[5],row; // 5 values per row
        int numOfRows=0,i;

        while((row=reader.readLine()) != null){ // understanding each value separated by comma
            if(!line.strip().equals("")){ // check for empty string
                rowItems = line.split(","); // separating values
                dataRows[numOfRows++] = rowItems; //adding values to an array
            }
        }

        Scanner scnr = new Scanner(System.in);
        int option;
        System.out.println("What would you like to update?"); // menu
        System.out.println("");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Email");

        option = scnr.nextInt();

        if (option == 1){

            int rowIndex = 0; // set the index to 0 to be the position of first name

            System.out.println("Please confirm your existing first name: ");
            String oldFirstName = input.next();
            System.out.println("Please enter your new first name: ");
            String newFirstName = input.next();

            Boolean flag = false;

            for (i=0; i<numOfRows; i++){ // loop to check for name

                if(dataRows[i][rowIndex].strip().equals(oldFirstName.strip())){

                    dataRows[i][rowIndex] = newFirstName; // insert the new name
                    flag = true; // name is found
                    break;
                }
            }

            if (flag == true){
                BufferedWriter buffWriter = new BufferedWriter(new Filewriter(txtFile));

                for (i=0; i<numOfRows; i++){
                    buffWriter.write(String.join(",",dataRows[]) + "\n"); // new entry back into the file separating values with comma
                }
                buffWriter.close();
            }
            else{
                System.out.println("Name not found.")
            }


        }else if(option == 2){
            int rowIndex = 1;

            System.out.println("Please confirm your existing last name: ");
            String oldLastName = input.next();
            System.out.println("Please enter your new last name: ");
            String newLastName = input.next();

            Boolean flag = false;

            for (i=0; i<numOfRows; i++){

                if(dataRows[i][rowIndex].strip().equals(oldLastName.strip())){

                    dataRows[i][rowIndex] = newLastName;
                    flag = true;
                    break;
                }
            }

            if (flag == true){
                BufferedWriter buffWriter = new BufferedWriter(new Filewriter(txtFile));

                for (i=0; i<numOfRows; i++){
                    buffWriter.write(String.join(",",dataRows[]) + "\n");
                }
                buffWriter.close();
            }
            else{
                System.out.println("Last name not found.")
            }

        }else if(option == 3){
            int rowIndex = 2;

            System.out.println("Please confirm your existing email: ");
            String oldEmail = input.next();
            System.out.println("Please enter your new email: ");
            String newEmail = input.next();

            Boolean flag = false;

            for (i=0; i<numOfRows; i++){

                if(dataRows[i][rowIndex].strip().equals(oldEmail.strip())){

                    dataRows[i][rowIndex] = newEmail;
                    flag = true;
                    break;
                }
            }

            if (flag == true){
                BufferedWriter buffWriter = new BufferedWriter(new Filewriter(txtFile));

                for (i=0; i<numOfRows; i++){
                    buffWriter.write(String.join(",",dataRows[]) + "\n");
                }
                buffWriter.close();
            }
            else{
                System.out.println("Name not found.")
            }
        }else{
            System.out.println("Please enter a valid option.");
        }

    }
}
