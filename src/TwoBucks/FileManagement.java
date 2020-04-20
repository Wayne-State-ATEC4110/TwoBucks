/**
 * <h1>FileManagement</h1>
 * The FileManagement class is used for saving and loading
 * User infromation onto Users.txt. These methods are called
 * in the CreateUserProfile class, LoadUserProfile class, and
 * the main.
 *
 * <p>
 *
 *
 * @author  Alex Gonzalez
 * @version 1.0
 * @since   03-04-2020
 */


package TwoBucks;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;

public class FileManagement {

    /**
     * Method creates Users.txt file if no already created
     * @throws IOException
     */
    public void createFile()throws IOException{

            try {

                File myFile = new File("Users.txt");

                if (myFile.createNewFile()){
                    System.out.println("Users.txt Created");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }


    /**
     * Method to save users to Users.txt
     * @param saveUser
     * @throws IOException
     */
    public void saveFile(User saveUser) throws IOException{

        //load existing Users
        ArrayList<String> list = new ArrayList<>();
        list = loadFile();

        //check for duplicate email in file
        //if duplicate email, update that line
        String[] check;

        //search array list for user
        int count = 0;
        while(true){

            //if user not found
            if(count == list.size()){
                //add user to list
                list.add(saveUser.toString());
                break;

            }

            //splits user string into separate pieces to represent User variables.
            check = list.get(count).split(", ",5);

            //if user found load user
            if(check[2].equals(saveUser.getEmail())){
                // Update user info
                list.set(count,saveUser.toString());
                break;

            }


            count++;

        }


        //create writer
        FileWriter writer = new FileWriter("Users.txt");

        //writes to Users.txt
        for(int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                writer.write(list.get(i).charAt(j));
            }
            writer.write("\n");
        }
        //close writer
        writer.close();
    }



    /**
     * Method loads saved user classes from Users.txt
     * Method returns list of all users saved variables
     *
     * @return list
     * @throws IOException
     */
    public ArrayList<String> loadFile() throws IOException{

        //create scanner object to read .txt file
        Scanner scan = new Scanner(new File("Users.txt"));

        //create ArrayList to save values from Users.txt
        ArrayList<String> list = new ArrayList<String>();
        while (scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        //close scanner
        scan.close();

        return list;


    }

    public boolean checkEmail(String email,ArrayList<String> list){

        String[] check;

        //search array list for user
        int i = 0;
        while(true){

            //if user not found
            if(i == list.size()){
                return false;
            }

            //splits user string into separate pieces to represent User variables.
            check = list.get(i).split(", ",5);

            //if user found load user
            if(check[2].equals(email)){
                return true;
            }


            i++;

        }

    }


}
