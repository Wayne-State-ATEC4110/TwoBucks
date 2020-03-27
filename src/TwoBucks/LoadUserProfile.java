/**
 * <h1>LoadUserProfile</h1>
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

import java.util.*;

public class LoadUserProfile {


    /**
     * The loadUser method takes an ArrayLis of strings which
     * in this program will come from the loadUser method in
     * the FileManagement class
     *
     * @param ArrayList users
     * @return User loadUser
     */
    public User loadUser(ArrayList<String> users){
        //initialize user class
        User loadUser = new User();

        //initialize string array to check for user name
        String[] check;

        //read txt file into array list
        Scanner scan = new Scanner(System.in);

        //prompt user for first and last name separated by space
        System.out.println("Login: Enter your email address");
        String input = scan.nextLine();

        //split string to first and last name
        String email = input;

        //search array list for user
        int i = 0;
        while(true){

            //if user not found
            if(i == users.size()){
                System.out.println("No profile with email "+ email +"Try again or create new profile");
                break;
            }

            //splits user string into separate pieces to represent User variables.
            check = users.get(i).split(", ",5);

            //if user found load user
            if(check[2].equals(email)){
                System.out.println("Welcome "+check[0]+" "+check[1]);
                loadUser = new User(check[0],check[1],check[2],Double.parseDouble(check[3]),Double.parseDouble(check[4]));
                break;
            }


            i++;

        }

        return loadUser;

    }
}
