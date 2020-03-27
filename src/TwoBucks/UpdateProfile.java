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

import java.util.*;
import java.io.*;


public class UpdateProfile {
    /***
     * This function will read from the text file where the
     * User information is stored and change the user's choice
     * of first name, last name, or email address
     * @param currentUser
     * @return currentUser
     */
    public User readFile(User currentUser){

        Scanner scnr = new Scanner(System.in);
        int option;
        System.out.println("What would you like to update?"); // menu
        System.out.println("");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Email");

        option = scnr.nextInt();

        if (option == 1){
            System.out.println("Please confirm your existing first name: ");

            while(true) {
                String oldFirstName = input.next();
                if(oldFirstName != currentUser.getFirstName()){ // check if the user's input matches existing
                    System.out.println("This first name does not exist. Please try again: ");
                }

                System.out.println("Please enter your new first name: ");
                currentUser.setFirstName(input.next()); // use set function to set new first name


            }else if(option == 2){

                System.out.println("Please confirm your existing last name: ");

                while(true) {
                    String oldLastName = input.next();
                    if(oldLastName != currentUser.getLastName()){
                        System.out.println("This last name does not exist. Please try again: ");
                    }
                }
                System.out.println("Please enter your new last name: ");
                currentUser.setLastName(input.next());

            }else if(option == 3){

                System.out.println("Please confirm your existing email: ");

                while(true) {
                    String oldEmail = input.next();
                    if(oldEmail != currentUser.getEmail()){
                        System.out.println("This email does not exist. Please try again: ");
                    }
                }
                System.out.println("Please enter your new first name: ");
                currentUser.setEmail(input.next());

            }else{
                System.out.println("Please enter a valid option.");
            }

            return currentUser;

        }
    }
