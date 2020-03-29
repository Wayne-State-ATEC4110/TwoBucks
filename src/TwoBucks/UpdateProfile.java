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

package TwoBucks;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;


public class UpdateProfile {
    /***
     * This function will read from the text file where the
     * User information is stored and change the user's choice
     * of first name, last name, or email address
     * @param currentUser
     * @return currentUser
     */
    public User updateInfo(User currentUser)throws IOException{

        Scanner scnr = new Scanner(System.in);
        FileManagement saver = new FileManagement();
        Menu menu = new Menu();
        int option;
        System.out.println("What would you like to update?"); // menu
        System.out.println("");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Email");
        System.out.println("4. Back To Main Menu");


        option = scnr.nextInt();
        String oldFirstName;

        if (option == 1) {
            System.out.println("Please confirm your existing first name: ");
            oldFirstName = scnr.next();

            while (!(oldFirstName.equals(currentUser.getFirstName()))) {

                System.out.println("This first name does not exist. Please try again: ");
                oldFirstName = scnr.next();
            }

            System.out.println("Please enter your new first name: ");
            currentUser.setFirstName(scnr.next()); // use set function to set new first name

            System.out.println("Saved Successfully!");
            updateInfo(currentUser);


        }
        else if(option == 2){

            System.out.println("Please confirm your existing last name: ");
            String oldLastName = scnr.next();

            while (!(oldLastName.equals(currentUser.getLastName()))) {

                System.out.println("This first name does not exist. Please try again: ");
                oldLastName = scnr.next();
            }

            System.out.println("Please enter your new first name: ");
            currentUser.setLastName(scnr.next()); // use set function to set new first name

            System.out.println("Saved Successfully!");
            updateInfo(currentUser);

        }else if(option == 3){

            System.out.println("Please confirm your existing email: ");
            String oldEmail = scnr.next();

            while (!(oldEmail.equals(currentUser.getFirstName()))) {

                System.out.println("This first name does not exist. Please try again: ");
                oldEmail = scnr.next();
            }

            System.out.println("Please enter your new first name: ");
            currentUser.setEmail(scnr.next()); // use set function to set new first name

            System.out.println("Saved Successfully!");
            updateInfo(currentUser);

        }else if(option == 4){
            saver.saveFile(currentUser);
            menu.showOptions();
        }
        else{
            System.out.println("Please enter a valid option.");
        }

        return currentUser;

    }
}