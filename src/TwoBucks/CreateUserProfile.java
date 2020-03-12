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


    //method to create user profile

    /**
     *
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

        //prompt user for first name
        System.out.println("Enter your first name: ");
        firstName = scan.nextLine();

        //prompt user for last name
        System.out.println("Enter your last name: ");
        lastName = scan.nextLine();

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
