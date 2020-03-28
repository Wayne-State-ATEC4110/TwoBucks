package TwoBucks;

import java.util.Scanner;

/**
 * @author  Sawyer Kisha
 * @version 1.3
 * @since   1.0
 * Menu.java
 */
public class Menu
{

    private int option;

    /**
     *  Displays list of options for intro menu
     */
    public void showIntroOptions()
    {
        System.out.println("Welcome to TwoBucks ");
        System.out.println("   ");
        System.out.println("1. Create New Profile ");
        System.out.println("2. Load Profile ");
        System.out.println("3. Exit ");
    }

    /**
     * Displays list of options for main menu
     */
    public void showOptions()
    {
        System.out.println("1. Weekly Income ");
        System.out.println("2. Weekly Expense ");
        System.out.println("3. Financial Goals ");
        System.out.println("4. Debt Calculator ");
        System.out.println("5. Exit ");
    }

    /**
     * constructor for option
     * @return option
     */
    public int getOption() {
        return this.option;
    }

    /**
     * Uses the user input integer choice
     * which is then used for a switch case
     * in order to send the user to their
     * desired profile interface
     * @return choice
     */
    public int selectIntroOption()
    {
        //Getting user input
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option: ");
        try
        {
            choice = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Please enter a numerical value ");
        }

        switch(choice)
        {
            case 1:
                //Create New Profile
                this.option = 1;
                System.out.println("Create User: ");
                break;
            case 2:
                //Load Profile
                this.option = 2;
                System.out.println("Load Profile: ");
                break;
            case 3:
                //Exiting the application
                this.option = 3;
                System.out.println("TwoBucks application closing...");
                break;
            default:
                //If invalid input
                System.out.println("Invalid option");
                selectIntroOption();
                break;
        }

        return choice;

    }

    /**
     * Uses the user input integer choice
     * which is then used for a switch case
     * in order to send the user to their
     * desired interface
     * @return choice
     */
    public int selectOption()
    {

        //Getting user input
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option: ");
        try
        {
            choice = scanner.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Please enter a numerical value ");
        }

       //Each option leads to different feature
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
                //selectOption();
                break;
        }

        return choice;

    }
}