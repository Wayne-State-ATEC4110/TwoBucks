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
        System.out.println("5. Display Goals ");
        System.out.println("6. Budget ");
        System.out.println("7. Update Profile ");
        System.out.println("8. Exit ");
    }

    /**
     * Displays list of options for budget menu
     */
    public void showBudgetOptions()
    {
        System.out.println("1. Display Current Budget ");
        System.out.println("2. Add to Budget ");
        System.out.println("3. Remove from Budget ");
        System.out.println("4. Return to main menu ");
    }

    /**
     * constructor for option
     * @return option
     */
    public int getOption()
    {
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
     * desired budget interface
     * @return
     */
    public int selectBudgetOption()
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
                //
                this.option = 1;
                System.out.println("Display Budget: ");
                break;
            case 2:
                //Add to Budget
                this.option = 2;
                System.out.println("Add to Budget: ");
                break;
            case 3:
                //Remove from Budget
                this.option = 3;
                System.out.println("Remove from Budget: ");
                break;
            case 4:
                //Exiting the application
                this.option = 4;
                System.out.println("Returning to main menu...");
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
                //Debt Calculator
                this.option = 4;
                System.out.println("Debt Calculator: ");
                break;
            case 5:
                //Display Goals
                this.option = 5;
                System.out.println("Display Goals: ");
                break;
            case 6:
                //Budget
                this.option = 6;
                System.out.println("Budget: ");
                break;
            case 7:
                //Display Goals
                this.option = 7;
                System.out.println("Update Profile: ");
                break;
            case 8:
                //Exiting the application
                this.option = 8;
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