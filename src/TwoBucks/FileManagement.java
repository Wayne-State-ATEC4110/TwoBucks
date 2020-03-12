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

    //save file method



    public void saveFile(String saveUser) throws IOException{

        //create writer
        FileWriter writer = new FileWriter("Users.txt");

        //
        for (int i = 0; i < saveUser.length(); i++){
            writer.write(saveUser.charAt(i));
        }
        //close writer
        writer.close();

    }

    //new save file method
    public



    //load file method

    /**
     * Method loads saved user classes from Users.txt
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


}
