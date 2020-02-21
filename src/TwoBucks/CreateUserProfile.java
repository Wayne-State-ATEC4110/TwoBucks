package TwoBucks;

import java.util.Scanner;

public class CreateUserProfile {


    //method to create user profile
    public User createUser() {
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
