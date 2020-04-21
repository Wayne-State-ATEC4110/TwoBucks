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
    public User loadUser(ArrayList<String> users) {
        //initialize user class
        User loadUser = new User();
        Budget budget = new Budget();
        Week initialWeek = new Week();
        Week previousWeek = new Week();

        //initialize string array to check for user name
        String[] check;

        //read txt file into array list
        Scanner scan = new Scanner(System.in);

        boolean profileOption = true;
        while (profileOption == true) {

            //prompt user for first and last name separated by space
            System.out.println("Login: Enter your email address");
            String input = scan.nextLine();

            //split string to first and last name
            String email = input;

            //search array list for user
            int i = 0;
            while (true) {

                //if user not found
                if (i == users.size()) {
                    System.out.println("No profile with email " + email + " found in TwoBucks database.");
                    System.out.println("Try again or create new profile.");
                    User userNotFound = new User();
                    userNotFound.setEmail("failedToLoad");
                    return userNotFound;
                }

                //splits user string into separate pieces to represent User variables.
                check = users.get(i).split(", ", 50);

                //if user found load user
                if (check[2].equals(email)) {
                    System.out.println("Welcome " + check[0] + " " + check[1]);
                    loadUser = new User(check[0], check[1], check[2], Double.parseDouble(check[3]), Double.parseDouble(check[4]),
                            Double.parseDouble(check[5]), Double.parseDouble(check[6]),
                            //user budget constructor
                            new Budget(Double.parseDouble(check[7]), Double.parseDouble(check[8]), Double.parseDouble(check[9]),
                                    Double.parseDouble(check[10]), Double.parseDouble(check[11]), Double.parseDouble(check[12]),
                                    Double.parseDouble(check[13]), Double.parseDouble(check[14]), Double.parseDouble(check[15]),
                                    Double.parseDouble(check[16]), Double.parseDouble(check[17])),
                            //inital week constructor
                            new Week(Double.parseDouble(check[18]), Double.parseDouble(check[19]),
                                    Double.parseDouble(check[20]), Double.parseDouble(check[21]),
                                    new Budget(Double.parseDouble(check[22]), Double.parseDouble(check[23]),
                                            Double.parseDouble(check[24]), Double.parseDouble(check[25]),
                                            Double.parseDouble(check[26]), Double.parseDouble(check[27]),
                                            Double.parseDouble(check[28]), Double.parseDouble(check[29]),
                                            Double.parseDouble(check[30]), Double.parseDouble(check[31]),
                                            Double.parseDouble(check[32]))),
                            //previous week constructor
                            new Week(Double.parseDouble(check[33]), Double.parseDouble(check[34]),
                                    Double.parseDouble(check[35]), Double.parseDouble(check[36]),
                                    new Budget(Double.parseDouble(check[37]), Double.parseDouble(check[38]),
                                            Double.parseDouble(check[39]), Double.parseDouble(check[40]),
                                            Double.parseDouble(check[41]), Double.parseDouble(check[42]),
                                            Double.parseDouble(check[43]), Double.parseDouble(check[44]),
                                            Double.parseDouble(check[45]), Double.parseDouble(check[46]),
                                            Double.parseDouble(check[47]))), Double.parseDouble(check[48]),
                                            Boolean.parseBoolean(check[49]));

                    profileOption = false;
                    break;
                }


                i++;

            }
        }
        return loadUser;

    }
}