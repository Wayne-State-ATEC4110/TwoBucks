//Author: Alex Gonzalez

package TwoBucks;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;

public class FileManagement {

    public void saveFile(String saveUser) throws IOException{


        FileWriter writer = new FileWriter("Users.txt");

        for (int i = 0; i < saveUser.length(); i++){
            writer.write(saveUser.charAt(i));
        }

        writer.close();

    }

    public ArrayList<String> loadFile() throws IOException{

        Scanner scan = new Scanner(new File("Users.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (scan.hasNextLine()){
            list.add(scan.nextLine());
        }
        scan.close();

        return list;


    }


}
