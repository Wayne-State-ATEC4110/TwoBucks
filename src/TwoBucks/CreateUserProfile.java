/**
 * <h1>CreateUserProfile</h1>
 * The LoadUserProfile class is used in the main.
 * The user is asekd for their name and email adress.
 * They systme creates a user profile for them based
 * on their inputs, which will allow them to log in.
 *
 * <p>
 *
 *
 * @author  Alex Gonzalez
 * @version 1.0
 * @since   03-04-2020
 */

package TwoBucks;

import java.io.IOException;
import java.util.Scanner;

public class CreateUserProfile {


    /**
     * Method checks if user input contains only alpha characters
     *
     * @param str
     * @return true or false
     */
    public Boolean checkAlpha(String str){

        return (str != null) && //check if string is not null
                (!str.equals("")) && // check if string is not empty
                (str.matches("^[a-zA-Z]*$")); //check for alpha characters
    }

    /**
     * Method to create User Profile
     *
     * @return User
     * @throws IOException
     */
    public User createUser() throws IOException {
        String firstName;
        String lastName;
        //String password;      //may use in future sprint
        String email;


        //create scanner
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                //prompt user for first name
                System.out.println("Enter your first name: ");
                firstName = scan.nextLine();
                if (checkAlpha(firstName) == true) {
                    break;
                }
                else
                    throw new Exception("Invalid Input");
            }
            catch (Exception e){
                System.out.println("Please enter name with only Alphabet characters");

            }

        }


        while(true) {
            try {
                //prompt user for last name
                System.out.println("Enter your last name: ");
                lastName = scan.nextLine();
                if (checkAlpha(lastName) == true) {
                    break;
                }
                else{
                    throw new Exception("Invalid Input");
                }
            }
            catch (Exception e){
                System.out.println("Please enter name with only Alphabet characters");
            }

        }



        //prompt user for email address
        System.out.println("Enter your email address: ");
        email = scan.nextLine();

        //Greeting with user name, indicates successful profile creation
        System.out.println("Welcome "+firstName+" "+lastName+"! Your User Profile has been created.");

        //create and return new user class.
        User user = new User(firstName,lastName,email);
        return user;


    }






}