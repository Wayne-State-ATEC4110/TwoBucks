package TwoBucks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;

public class FileManagement {

    public void saveFile(String saveUser) throws IOException{


        FileWriter writer = new FileWriter("Users.txt");

        for (int i = 0; i < saveUser.length(); i++){
            writer.write(saveUser.charAt(i));
        }

        writer.close();

    }

    public void loadFile() throws IOException{

        int position;
        //if file exists, user file loads.
        FileReader readFile = null;
        try {
            readFile = new FileReader("Users.txt");
        }
        catch (FileNotFoundException fe) {
            System.out.println("File not found!");
        }

        //read file

        String loadString = "";

        while((position = readFile.read())!= -1 ) {
            //System.out.print((char)position);
            loadString += (char)position;

        }
        System.out.println(loadString);

    }


}
