package TwoBucks;

import java.util.*;

public class LoadUserProfile {

        public User loadUser(ArrayList<String> users){
        //initialize user class
        User loadUser = new User();

        //initialize string array to check for user name
        String[] check;

        //read txt file into array list
        Scanner scan = new Scanner(System.in);

        //prompt user for first and last name separated by space
        System.out.println("Enter first and last name");
        String input = scan.nextLine();

        //split string to first and last name
        String[] fullName = input.split(" ",2);

        //search array list for user
        int i = 0;
        while(true){

            //if user not found
            if(i == users.size()){
                System.out.println("No profile with name "+ fullName[0]+" "+fullName[1]);
                break;
            }

            //splits user string into separate pieces to represent User variables. 
            check = users.get(i).split(", ",5);

            //if user found load user
            if(check[0].equals(fullName[0]) && check[1].equals(fullName[1]) ){
                System.out.println("Welcome "+fullName[0]+" "+fullName[1]);
                loadUser = new User(check[0],check[1],check[2],Double.parseDouble(check[3]),Double.parseDouble(check[4]));
                break;
            }


            i++;

        }

        return loadUser;

    }
}
