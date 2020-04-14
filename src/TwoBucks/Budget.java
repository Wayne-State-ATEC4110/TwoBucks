
/**
 * <h1>Budget</h1>
 *
 * <p>The Budget class allows for a budget to be created or edited after initially created
 * It belongs to the User class.</p>
 *
 * @author Mike Shea
 * @version 1.0
 * @since 3/27/20
 */

// Fix javadocs comments

package TwoBucks;

import java.util.*;

/**
 * Composition: Member of User class (HAS-A relationship)
 *
 * The Budget class handles all categorized budgeting.
 * The user enters income and expenses by category
 * The user can add or remove from categories after initial input
 */

public class Budget {

    // Budget members
    private double totalIncome;
    private double wageIncome;
    private double otherIncome;
    private double rentExpenses;
    private double utilitiesExpenses;
    private double foodExpenses;
    private double travelExpenses;
    private double healthcareExpenses;
    private double entertainmentExpenses;
    private double totalExpenses;
    private double monthlyNetChange;    // (Income - Expenses)
    private int userSelection = 0;
    private Scanner scan = new Scanner(System.in);
    private BudgetReminder budgetReminder;

    /**
     * Default Constructor to initialize fields
     */
    public Budget(){
        wageIncome = 0.0;
        otherIncome = 0.0;
        totalIncome = 0.0;
        rentExpenses = 0.0;
        utilitiesExpenses = 0.0;
        foodExpenses = 0.0;
        travelExpenses = 0.0;
        healthcareExpenses = 0.0;
        entertainmentExpenses = 0.0;
        totalExpenses = 0.0;
        monthlyNetChange = 0.0;
        userSelection = 0;
    }

    /**
     * Argument Constructor to initialize fields without user input
     */
    public Budget(double wages, double otherIncomeSource, double totalIncome, double rent, double utilities,
                  double food, double travel, double health,
                  double entertainment, double totalExpenses, double monthlyNetChange){
        this.wageIncome = wages;
        this.otherIncome = otherIncomeSource;
        this.totalIncome = totalIncome;
        this.rentExpenses = rent;
        this.utilitiesExpenses = utilities;
        this.foodExpenses = food;
        this.travelExpenses = travel;
        this.travelExpenses = food;
        this.healthcareExpenses = health;
        this.entertainmentExpenses = entertainment;
        this.totalExpenses = totalExpenses;
        this.monthlyNetChange = monthlyNetChange;

        //CalculateTotalIncome();
        //CalculateTotalExpenses();
        //CalculateMonthlyNetChange();
    }

    /**
     * Class toString method used to export class members into one string for saving
     *
     * @return String of class members separated by comma and space
     */

    @Override
    public String toString() {
        return wageIncome + ", " + otherIncome + ", " + totalIncome + ", " + rentExpenses + ", " + utilitiesExpenses + ", "
                + foodExpenses + ", " + travelExpenses + ", " + healthcareExpenses
                + ", " + entertainmentExpenses + ", " + totalExpenses + ", " + monthlyNetChange;
    }

    /**
     * Creates budget with user-entered values
     * User can add or remove from their budget after the initial input
     * by following the menu prompts.
     */

    public void CreateBudget() {
        try {
            // Receive User Input
            ReceiveWageIncome();
            ReceiveOtherIncome();
            ReceiveRentExpenses();
            ReceiveUtilitiesExpenses();
            ReceiveFoodExpenses();
            ReceiveTravelExpenses();
            ReceiveHealthcareExpenses();
            ReceiveEntertainmentExpenses();

            // Calculate & Display
            CalculateTotalIncome();
            CalculateTotalExpenses();
            CalculateMonthlyNetChange();
            DisplayBudget();

            // User Control Flow
            ReceiveUserSelection();
            while (userSelection != 3) {

                // Add purchase to budget
                if (userSelection == 1) {

                    AddToBudget();

                    DisplayBudget();
                    ReceiveUserSelection();
                }
                // Remove purchase from budget
                else if (userSelection == 2) {
                    RemoveFromBudget();
                    DisplayBudget();
                    ReceiveUserSelection();
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Unrecoverable input entered.");
        } finally {
            // Close input stream
        }
    }

    /**
     * Displays current class members
     */
    public void DisplayBudget() {
        System.out.println("Wage Income: $" + String.format("%.2f", wageIncome));
        System.out.println("Other Income: $" + String.format("%.2f", otherIncome));
        System.out.println("==========================");
        System.out.println("Total Income: $" + String.format("%.2f", totalIncome));
        System.out.println();
        System.out.println("Rent/mortgage: $" + String.format("%.2f", rentExpenses));
        System.out.println("Utilities: $" + String.format("%.2f", utilitiesExpenses));
        System.out.println("Food: $" + String.format("%.2f", foodExpenses));
        System.out.println("Travel: $" + String.format("%.2f", travelExpenses));
        System.out.println("Healthcare: $" + String.format("%.2f", healthcareExpenses));
        System.out.println("Entertainment: $" + String.format("%.2f", entertainmentExpenses));
        System.out.println("==========================");
        System.out.println("Total Expenses: " + String.format("%.2f", totalExpenses));
        System.out.println();
        System.out.println("Net change: $" + String.format("%.2f", monthlyNetChange));
        System.out.println();
    }

    /**
     * Prompts the user to enter their monthly wages
     * @throws InputMismatchException
     */
    private void ReceiveWageIncome() throws InputMismatchException {
        System.out.print("Enter your income from wages (after tax): $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for your wages: $");
            scan.next();
        }

        wageIncome = scan.nextDouble();

        // Validate input - must be positive value
        while (wageIncome <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for your wages: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for your wages: $");
                scan.next();
            }

            wageIncome = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream
    }

    /**
     * Prompts the user to enter their income from all other sources
     * @throws InputMismatchException
     */
    private void ReceiveOtherIncome() throws InputMismatchException {
        System.out.print("Enter your income all other sources: $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for the income: $");
            scan.next();
        }

        otherIncome = scan.nextDouble();

        // Validate input - must be positive value
        while (otherIncome <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the income: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the income: $");
                scan.next();
            }

            otherIncome = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream
    }

    /**
     * Prompts the user to enter their monthly rent/mortgage payment
     *
     * @throws InputMismatchException
     */
    private void ReceiveRentExpenses() throws InputMismatchException {
        System.out.print("Enter the amount spent on this month's rent/mortgage: $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for the rent/mortgage payment: $");
            scan.next();
        }

        rentExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while (rentExpenses <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the rent/mortgage payment: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the rent/mortgage payment: $");
                scan.next();
            }

            rentExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream
    }

    /**
     * Prompts the user to enter their utilities expenses
     *
     * @throws InputMismatchException
     */
    private void ReceiveUtilitiesExpenses() throws InputMismatchException {
        System.out.print("Enter the amount spent on utilities (electric, water, phone, ect): $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for the utilities payment: $");
            scan.next();
        }

        utilitiesExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while (utilitiesExpenses <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the utilities payment: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the utilities payment: $");
                scan.next();
            }

            utilitiesExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their food expenses
     *
     * @throws InputMismatchException
     */
    private void ReceiveFoodExpenses() throws InputMismatchException {

        System.out.print("Enter the amount spent on food: $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for the food payment: $");
            scan.next();
        }

        foodExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while (foodExpenses <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the food payment: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the food payment: $");
                scan.next();
            }

            foodExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their travel expenses
     *
     * @throws InputMismatchException
     */
    private void ReceiveTravelExpenses() throws InputMismatchException {
        System.out.print("Enter the total spent on travel (car payments/repairs, gasoline, public transport, ect): $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for the travel expenses: $");
            scan.next();
        }

        travelExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while (travelExpenses <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the travel expenses: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the travel expenses: $");
                scan.next();
            }

            travelExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their healthcare expenses
     *
     * @throws InputMismatchException
     */
    private void ReceiveHealthcareExpenses() throws InputMismatchException {

        System.out.print("Enter the amount spent on healthcare expenses (including insurance): $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for healthcare expenses: $");
            scan.next();
        }

        healthcareExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while (healthcareExpenses <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the healthcare expenses: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the utilities payment: $");
                scan.next();
            }

            healthcareExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their entertainment expenses
     *
     * @throws InputMismatchException
     */
    private void ReceiveEntertainmentExpenses() throws InputMismatchException {

        System.out.print("Enter the amount spent on entertainment: $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for entertainment expenses: $");
            scan.next();
        }

        entertainmentExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while (entertainmentExpenses <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for entertainment expenses: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for entertainment expenses: $");
                scan.next();
            }

            entertainmentExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Calculates the total income
     */
    private void CalculateTotalIncome(){
        totalIncome = wageIncome + otherIncome;
    }

    /**
     * Calculates the total expenses
     */
    private void CalculateTotalExpenses(){
        totalExpenses = rentExpenses + utilitiesExpenses +
                foodExpenses + travelExpenses + healthcareExpenses + entertainmentExpenses;
    }

    /**
     * Calculates the monthly net change (income - expenses)
     */
    private void CalculateMonthlyNetChange() {
        CalculateTotalIncome();
        CalculateTotalExpenses();
        monthlyNetChange = totalIncome - totalExpenses;
    }

    /**
     * Receives user input for menu
     *
     * @throws InputMismatchException
     */
    public void ReceiveUserSelection() throws InputMismatchException {
        // User Menu
        System.out.println("Enter an option from the menu below.");
        System.out.println("1. Add purchase to budget");
        System.out.println("2. Remove purchase from budget");
        System.out.println("3. Continue with current budget");

        // Must be an integer
        while (!scan.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid numerical option as shown in the menu.");
            scan.next();
        }

        userSelection = scan.nextInt();

        while (userSelection <= 0 || userSelection > 3) {
            System.out.print("Invalid input. Please enter a valid numerical option as shown in the menu.");

            while (!scan.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid numerical option as shown in the menu.");
                scan.next();
            }

            userSelection = scan.nextInt();
        }

    }



    /**
     * User inputs an amount to add to a
     * specific budget category, includes
     * exception handling
     *
     * @throws InputMismatchException
     */
    public void AddToBudget() throws InputMismatchException {
        double amount = 0;
        int selection = 0;

        BudgetReminder budgetReminder = new BudgetReminder();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a category from the menu below to remove an amount from:");
        System.out.println("1. Wage Income");
        System.out.println("2. Other Income");
        System.out.println("3. Mortgage/Rent");
        System.out.println("4. Utilities");
        System.out.println("5. Food");
        System.out.println("6. Travel");
        System.out.println("7. Healthcare");
        System.out.println("8. Entertainment");
        System.out.println("9. Return to previous menu");

        //Make sure integer
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. ");
            scanner.next();
        }
        selection = scanner.nextInt();

        //Make sure accepted integer
        while (selection <= 0 || selection > 8) {
            System.out.print("Invalid input. ");

            // Make sure integer
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. ");
                scanner.next();
            }

            selection = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.print("Enter the amount you would like to add: $");
        amount = getAmount();

        switch (selection) {

            case 1:
                //Add to total income
                wageIncome += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 2:
                otherIncome += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 3:
                //Add to rent
                rentExpenses += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 4:
                //Add to utilities
                utilitiesExpenses += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 5:
                //Add to food
                foodExpenses += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 6:
                //Add to travel
                travelExpenses += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 7:
                //Add to healthcare
                healthcareExpenses += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 8:
                //Add to entertainment
                entertainmentExpenses += amount;
                budgetReminder.BudgetAddReminder(amount);
                break;
            case 9:
                break;
            default:
                break;

        }

        CalculateTotalExpenses();
        CalculateTotalIncome();
        CalculateMonthlyNetChange();
    }

    /**
     * Prompts the user to select a category to remove an amount from,
     * then prompts the user to select an amount to remove. If the amount is greater
     * than what is currently in the category, the category will be reduced to zero.
     *
     * @throws InputMismatchException
     */
    public void RemoveFromBudget() throws InputMismatchException {
        int selection = 0;
        double amount = 0;


        System.out.println("Select a category from the menu below to remove an amount from:");
        System.out.println("1. Wage Income");
        System.out.println("2. Other Income");
        System.out.println("3. Mortgage/Rent");
        System.out.println("4. Utilities");
        System.out.println("5. Food");
        System.out.println("6. Travel");
        System.out.println("7. Healthcare");
        System.out.println("8. Entertainment");
        System.out.println("9. Return to previous menu");

        // Validate Input - must be Int type
        while (!scan.hasNextInt()) {
            System.out.print("Invalid input. Please enter an option from the menu above.");
            scan.next();
        }
        selection = scan.nextInt();

        // Validate input - must be positive value
        while (selection <= 0 || selection > 9) {
            System.out.print("Invalid input. Please enter an option from the menu above.");

            // Validate Input - must be Int type
            while (!scan.hasNextInt()) {
                System.out.print("Invalid input. Please enter an option from the menu above.");
                scan.next();
            }

            selection = scan.nextInt();
        }

        scan.nextLine();    // Clear input stream

        System.out.print("Enter the amount you would like to remove: $");
        amount = getAmount();

        switch (selection) {
            case 1:
                // Change wage income
                if (amount > wageIncome) {
                    wageIncome = 0;
                } else {
                    wageIncome -= amount;

                    budgetReminder.BudgetRemoveReminder(amount);
                }
                break;
            case 2:
                // Change other income
                if (amount > otherIncome) {
                    otherIncome = 0;
                } else {
                    otherIncome -= amount;

                    budgetReminder.BudgetRemoveReminder(amount);
                }
                break;
            case 3:
                // Change Mortage/rent
                if (amount > rentExpenses) {
                    rentExpenses = 0;
                } else {
                    rentExpenses -= amount;
                    budgetReminder.BudgetRemoveReminder(amount);

                }
                break;
            case 4:
                // Change Utilities
                if (amount > utilitiesExpenses) {
                    rentExpenses = 0;
                } else {
                    utilitiesExpenses -= amount;

                    budgetReminder.BudgetRemoveReminder(amount);

                }
                break;
            case 5:
                // Change Food
                if (amount > foodExpenses) {
                    foodExpenses = 0;
                } else {
                    foodExpenses -= amount;
                    budgetReminder.BudgetRemoveReminder(amount);

                }
                break;
            case 6:
                // Change Travel
                if (amount > travelExpenses) {
                    travelExpenses = 0;
                } else {
                    travelExpenses -= amount;

                    budgetReminder.BudgetRemoveReminder(amount);

                }
                break;
            case 7:
                // Change Healthcare
                if (amount > healthcareExpenses) {
                    healthcareExpenses = 0;
                } else {
                    healthcareExpenses -= amount;

                    budgetReminder.BudgetRemoveReminder(amount);

                }
                break;
            case 8:
                // Change Entertainment
                if (amount > entertainmentExpenses) {
                    entertainmentExpenses = 0;
                } else {
                    entertainmentExpenses -= amount;
                    budgetReminder.BudgetRemoveReminder(amount);

                }
                break;
            case 9:
                break;
            default:
                break;


        }
        CalculateTotalExpenses();
        CalculateTotalIncome();
        CalculateMonthlyNetChange();
    }

    /**
     * Prompts the user to enter a dollar amount and returns it
     *
     * @return double amount
     * @throws InputMismatchException
     */
    private double getAmount() throws InputMismatchException {

        double amount = 0;

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter an amount: $");
            scan.next();
        }

        amount = scan.nextDouble();

        // Validate input - must be positive value
        while (amount <= 0) {
            System.out.print("Invalid input. Please enter a positive amount: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter an amount: $");
                scan.next();
            }

            amount = scan.nextDouble();

            // Validate input - must be positive value
            while (amount <= 0) {
                System.out.print("Invalid input. Please enter a positive amount: $");

                // Validate Input - must be Double type
                while (!scan.hasNextDouble()) {
                    System.out.print("Invalid input. Please enter an amount: $");
                    scan.next();
                }

                amount = scan.nextDouble();
            }


        }

        scan.nextLine();    // Clear input stream
        return amount;
    }

    /**
     * GETTERS AND SETTERS
     */

    /**
     *
     * @return wageIncome double
     */
    public double getWageIncome(){ return wageIncome; }

    /**
     * @param  wageIncome double
     */
    public void setWageIncome(double wageIncome){this.wageIncome = wageIncome;}

    /**
     * @return otherIncome double
     */
    public double getOtherIncome() {return otherIncome; }

    /**
     * @param otherIncome double
     */
    public void setOtherIncome(double otherIncome){this.otherIncome = otherIncome;}


    /**
     * @return totalIncome double
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * @param totalIncome double
     */
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * @return rentExpenses double
     */
    public double getRentExpenses() {
        return rentExpenses;
    }

    /**
     * @param rentExpenses double
     */
    public void setRentExpenses(double rentExpenses) {
        this.rentExpenses = rentExpenses;
    }

    /**
     * @return utilitiesExpenses double
     */
    public double getUtilitiesExpenses() {
        return utilitiesExpenses;
    }

    /**
     * @param utilitiesExpenses double
     */
    public void setUtilitiesExpenses(double utilitiesExpenses) {
        this.utilitiesExpenses = utilitiesExpenses;
    }

    /**
     * @return foodExpenses double
     */
    public double getFoodExpenses() {
        return foodExpenses;
    }

    /**
     * @param foodExpenses double
     */
    public void setFoodExpenses(double foodExpenses) {
        this.foodExpenses = foodExpenses;
    }

    /**
     * @return travelExpenses double
     */
    public double getTravelExpenses() {
        return travelExpenses;
    }

    /**
     * @param travelExpenses double
     */
    public void setTravelExpenses(double travelExpenses) {
        this.travelExpenses = travelExpenses;
    }

    /**
     * @return healthcareExpenses double
     */
    public double getHealthcareExpenses() {
        return healthcareExpenses;
    }

    /**
     * @param healthcareExpenses double
     */
    public void setHealthcareExpenses(double healthcareExpenses) {
        this.healthcareExpenses = healthcareExpenses;
    }

    /**
     * @return healthcareExpenses double
     */
    public double getEntertainmentExpenses() {
        return entertainmentExpenses;
    }

    /**
     * @param entertainmentExpenses double
     */
    public void setEntertainmentExpenses(double entertainmentExpenses) {
        this.entertainmentExpenses = entertainmentExpenses;
    }

    /**
     *
     * @return totalExpenses double
     */
    public double getTotalExpenses(){return totalExpenses;}

    /**
     * @param totalExpenses double
     */
    public void setTotalExpenses(double totalExpenses){
        this.totalExpenses = totalExpenses;
    }

    /**
     *
     * @return monthlyNewChange double
     */
    public double getMonthlyNetChange() {
        return monthlyNetChange;
    }

    /**
     *
     * @param monthlyNetChange
     */
    public void setMonthlyNetChange(double monthlyNetChange){
        this.monthlyNetChange = monthlyNetChange;
    }

    /**
     *
     * @param reminder BudgetReminder
     */
    public void setBudgetReminder(BudgetReminder reminder){
        budgetReminder = reminder;
    }

}