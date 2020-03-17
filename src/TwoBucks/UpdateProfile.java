import java.util.*;
import java.io.*;

public class UpdateProfile {

    public static void readTxtFile(String[] args) throws Exception{
        File txtFile = new File("User.txt");
        BufferedReader reader = new BufferedReader(new FileReader(txtFile));
        String dataRows[][] = new String[100][5];
        String rowItems[] = new String[5],row;
        int numOfRows=0,i;

        while((row=reader.readLine()) != null){
            if(!row.strip().equals("")){
                rowItems = row.split(",");
                dataRows[numOfRows++] = rowItems;
            }
        }

        Scanner scnr = new Scanner(System.in);
        int option;
        System.out.println("What would you like to update?");
        System.out.println("");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Email");
        System.out.println("");
        System.out.println("Option: ");

        option = scnr.nextInt();

        if (option == 1){

            int rowIndex = 0;

            System.out.println("Please confirm your existing first name: ");
            String oldFirstName = scnr.next();
            System.out.println("Please enter your new first name: ");
            String newFirstName = scnr.next();

            Boolean flag = false;

            for (i=0; i<numOfRows; i++){

                if(dataRows[i][rowIndex].strip().equals(oldFirstName.strip())){

                    dataRows[i][rowIndex] = newFirstName;
                    flag = true;
                    break;
                }
            }

            if (flag == true){
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter(txtFile));

                for (i=0; i<numOfRows; i++){
                    buffWriter.write(String.join(",",dataRows[i]) + "\n");
                }
                buffWriter.close();
            }
            else{
                System.out.println("Name not found.");
            }


        }else if(option == 2){
            int rowIndex = 1;

            System.out.println("Please confirm your existing last name: ");
            String oldLastName = scnr.next();
            System.out.println("Please enter your new last name: ");
            String newLastName = scnr.next();

            Boolean flag = false;

            for (i=0; i<numOfRows; i++){

                if(dataRows[i][rowIndex].strip().equals(oldLastName.strip())){

                    dataRows[i][rowIndex] = newLastName;
                    flag = true;
                    break;
                }
            }

            if (flag == true){
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter(txtFile));

                for (i=0; i<numOfRows; i++){
                    buffWriter.write(String.join(",",dataRows[i]) + "\n");
                }
                buffWriter.close();
            }
            else{
                System.out.println("Last name not found.");
            }

        }else if(option == 3){
            int rowIndex = 2;

            System.out.println("Please confirm your existing email: ");
            String oldEmail = scnr.next();
            System.out.println("Please enter your new email: ");
            String newEmail = scnr.next();

            Boolean flag = false;

            for (i=0; i<numOfRows; i++){

                if(dataRows[i][rowIndex].strip().equals(oldEmail.strip())){

                    dataRows[i][rowIndex] = newEmail;
                    flag = true;
                    break;
                }
            }

            if (flag == true){
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter(txtFile));

                for (i=0; i<numOfRows; i++){
                    buffWriter.write(String.join(",",dataRows[i]) + "\n");
                }
                buffWriter.close();
            }
            else{
                System.out.println("Email not found.");
            }
        }else{
            System.out.println("Please enter a valid option.");
        }

    }
}
