package TwoBucks;

// Two Bucks
// US1. Main Menu
// By Sawyer Kisha

import java.util.Scanner;

public class Menu
{

    //Array list of options for main menu
    private String[] options = new String[5];
    private int option;

    public Menu()
    {
        options[0] = "1. Weekly Income";
        options[1] = "2. Weekly Expense";
        options[2] = "3. Financial Goals";
        options[3] = "4. Debt Calculator";
        options[4] = "5. Exit";
    }

    //Displays main menu to the user
    public void showOptions()
    {
        System.out.println("Select an option: ");
        for(int i = 0; i < options.length; i++)
        {
            System.out.println(options[i]);
        }
    }

    public int getOption() {
        return this.option;
    }

    public int selectOption()
    {

        //Getting user input
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option: ");
        choice = scanner.nextInt();

        //User input selects one of the following options
        //Each option leads to a different features
        switch(choice)
        {
            case 1:
                //Weekly Income
                this.option = 1;
                System.out.println("Weekly Income: ");
                break;
            case 2:
                //Weekly Expense
                this.option = 2;
                System.out.println("Weekly Expense: ");
                break;
            case 3:
                //Financial Goals
                this.option = 3;
                System.out.println("Financial Goals: ");
                break;
            case 4:
                //
                this.option = 4;
                System.out.println("Option 4");
                break;
            case 5:
                //Exiting the application
                this.option = 5;
                System.out.println("TwoBucks application closing...");
                break;
            default:
                //If invalid input
                System.out.println("Invalid option");
                selectOption();
                break;
        }

        return choice;

    }
}
