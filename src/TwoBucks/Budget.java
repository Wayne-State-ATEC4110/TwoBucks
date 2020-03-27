/**
 * <h1>Budget</h1>
 *
 * <p>The Budget class allows for a budget to be created or edited after initially created
 * It belongs to the User class.</p>
 *
 * TODO:    Let user know when amount removed exceeds current category amount
 *
 * @author Mike Shea
 * @version 1.0
 * @since 3/24/20
 */


import java.util.*;

package TwoBucks;

public class Budget {

    // Budget members
    private double totalIncome;
    private double rentExpenses;
    private double utilitiesExpenses;
    private double foodExpenses;
    private double travelExpenses;
    private double healthcareExpenses;
    private double entertainmentExpenses;
    private double monthlyNetChange;    // (Income - Expenses)
    private int userSelection = 0;
    private Scanner scan = new Scanner(System.in);

    /**
     * Class toString method used to export class members into one string for saving
     *
     * @return String of class members separated by comma and space
     */

    @Override
    public String toString() {
        return totalIncome + ", " + rentExpenses + ", " + utilitiesExpenses + ", "
                + foodExpenses + ", " + travelExpenses + ", " + healthcareExpenses
                + ", " + entertainmentExpenses + ", " + monthlyNetChange;
    }

    /**
     * Creates budget with user-entered values
     * User can add or remove from their budget after the initial input
     * by following the menu prompts.
     */

    public void CreateBudget() {
        try {
            ReceiveTotalIncome();
            ReceiveRentExpenses();
            ReceiveUtilitiesExpenses();
            ReceiveFoodExpenses();
            ReceiveTravelExpenses();
            ReceiveHealthcareExpenses();
            ReceiveEntertainmentExpenses();
            CalculateMonthlyNetChange();

            // Display Budget
            DisplayBudget();
            ReceiveUserSelection();

            while(userSelection != 3) {

                // Add purchase to budget
                if (userSelection == 1) {
                    System.out.print("Not yet implemented");
                    DisplayBudget();
                    ReceiveUserSelection();
                }
                // Remove purchase from budget
                else if (userSelection == 2) {
                    RemoveFromBudget();
                    DisplayBudget();
                    ReceiveUserSelection();
                } else {
                    // Nothing - continue with current budget
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Unrecoverable input entered.");
        } finally {
            // Close input stream
            scan.close();
        }
    }

    /**
     * Resets the class state
     */
    public void ResetValues(){
        totalIncome = 0;
        rentExpenses = 0;
        utilitiesExpenses = 0;
        foodExpenses = 0;
        travelExpenses = 0;
        healthcareExpenses = 0;
        entertainmentExpenses = 0;
        monthlyNetChange = 0;
        userSelection = 0;
    }

    /**
     * Returns the value of all expenses added together
     * @return double totalExpenses
     */
    public double GetTotalExpenses(){
        double totalExpenses = getRentExpenses() + getUtilitiesExpenses() + getFoodExpenses() +
                getTravelExpenses() + getHealthcareExpenses() + getEntertainmentExpenses();
        return totalExpenses;
    }

    /**
     * Displays current class members
     */
    public void DisplayBudget() {
        System.out.println("");
        System.out.println("Monthly Budget");
        System.out.println("==========================");
        System.out.println("Total Income: $" + String.format("%.2f", totalIncome));
        System.out.println("Rent/mortgage: $" + String.format("%.2f", rentExpenses));
        System.out.println("Utilities: $" + String.format("%.2f", utilitiesExpenses));
        System.out.println("Food: $" + String.format("%.2f", foodExpenses));
        System.out.println("Travel: $" + String.format("%.2f", travelExpenses));
        System.out.println("Healthcare: $" + String.format("%.2f", healthcareExpenses));
        System.out.println("Entertainment: $" + String.format("%.2f", entertainmentExpenses));
        System.out.println("Net change: $" + String.format("%.2f", monthlyNetChange));
        System.out.println();
    }

    /**
     * Prompts the user to enter their monthly total income
     *
     * @throws InputMismatchException
     */

    private void ReceiveTotalIncome() throws InputMismatchException {
        System.out.print("Enter your total income (include all sources of income): $");

        // Validate Input - must be Double type
        while (!scan.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a numerical value for the total income: $");
            scan.next();
        }

        totalIncome = scan.nextDouble();

        // Validate input - must be positive value
        while (totalIncome <= 0) {
            System.out.print("Invalid input. Please enter a positive numerical value for the total income: $");

            // Validate Input - must be Double type
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input. Please enter a numerical value for the total income: $");
                scan.next();
            }

            totalIncome = scan.nextDouble();
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
     * Calculates the monthly net change (income - expenses)
     *
     * @throws InputMismatchException
     */
    private void CalculateMonthlyNetChange() throws InputMismatchException {
        monthlyNetChange = totalIncome - (rentExpenses + utilitiesExpenses +
                foodExpenses + travelExpenses + healthcareExpenses + entertainmentExpenses);
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
     * @return double totalIncome
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * @param double totalIncome
     */
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * @return double rentExpenses
     */
    public double getRentExpenses() {
        return rentExpenses;
    }

    /**
     * @param double rentExpenses
     */
    public void setRentExpenses(double rentExpenses) {
        this.rentExpenses = rentExpenses;
    }

    /**
     * @return double utilitiesExpenses
     */
    public double getUtilitiesExpenses() {
        return utilitiesExpenses;
    }

    /**
     * @param double utilitiesExpenses
     */
    public void setUtilitiesExpenses(double utilitiesExpenses) {
        this.utilitiesExpenses = utilitiesExpenses;
    }

    /**
     * @return double foodExpenses
     */
    public double getFoodExpenses() {
        return foodExpenses;
    }

    /**
     * @param double foodExpenses
     */
    public void setFoodExpenses(double foodExpenses) {
        this.foodExpenses = foodExpenses;
    }

    /**
     * @return double travelExpenses
     */
    public double getTravelExpenses() {
        return travelExpenses;
    }

    /**
     * @param double travelExpenses
     */
    public void setTravelExpenses(double travelExpenses) {
        this.travelExpenses = travelExpenses;
    }

    /**
     * @return double healthcareExpenses
     */
    public double getHealthcareExpenses() {
        return healthcareExpenses;
    }

    /**
     * @param double healthcareExpenses
     */
    public void setHealthcareExpenses(double healthcareExpenses) {
        this.healthcareExpenses = healthcareExpenses;
    }

    /**
     * @return double healthcareExpenses
     */
    public double getEntertainmentExpenses() {
        return entertainmentExpenses;
    }

    /**
     * @param double entertainmentExpenses
     */
    public void setEntertainmentExpenses(double entertainmentExpenses) {
        this.entertainmentExpenses = entertainmentExpenses;
    }

    /**
     * Prompts the user to select a category to remove an amount from,
     * then prompts the user to select an amount to remove. If the amount is greater
     * than what is currently in the category, the category will be reduced to zero.
     * @throws InputMismatchException
     */
    public void RemoveFromBudget() throws InputMismatchException{
        int selection = 0;
        double amount = 0;

        System.out.println("Select a category from the menu below to remove an amount from:");
        System.out.println("1. Total Income");
        System.out.println("2. Mortgage/Rent");
        System.out.println("3. Utilities");
        System.out.println("4. Food");
        System.out.println("5. Travel");
        System.out.println("6. Healthcare");
        System.out.println("7. Entertainment");
        System.out.println("8. Return to previous menu");

        // Validate Input - must be Int type
        while (!scan.hasNextInt()) {
            System.out.print("Invalid input. Please enter an option from the menu above.");
            scan.next();
        }
        selection = scan.nextInt();

        // Validate input - must be positive value
        while (selection <= 0 || selection > 8) {
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

        switch(selection){
            case 1:
                // Change total income
                if(amount > totalIncome) {
                    totalIncome = 0;
                }
                else {
                    totalIncome -= amount;
                }
                break;
            case 2:
                // Change Mortage/rent
                if(amount > rentExpenses){
                    rentExpenses = 0;
                }
                else{
                    rentExpenses -= amount;
                }
                break;
            case 3:
                // Change Utilities
                if(amount > utilitiesExpenses){
                    rentExpenses = 0;
                }
                else{
                    utilitiesExpenses -= amount;
                }
                break;
            case 4:
                // Change Food
                if(amount > foodExpenses){
                    foodExpenses = 0;
                }
                else{
                    foodExpenses -= amount;
                }
                break;
            case 5:
                // Change Travel
                if(amount > travelExpenses){
                    travelExpenses = 0;
                }
                else{
                    travelExpenses -= amount;
                }
                break;
            case 6:
                // Change Healthcare
                if(amount > healthcareExpenses){
                    healthcareExpenses = 0;
                }
                else{
                    healthcareExpenses -= amount;
                }
                break;
            case 7:
                // Change Entertainment
                if(amount > entertainmentExpenses){
                    entertainmentExpenses = 0;
                }
                else{
                    entertainmentExpenses -= amount;
                }
                break;
            case 8:
                break;
            default:
                break;

        }
    }

    /**
     * Prompts the user to enter a dollar amount and returns it
     * @return double amount
     * @throws InputMismatchException
     */
    private double getAmount() throws InputMismatchException{
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
        }

        scan.nextLine();    // Clear input stream
        return amount;
    }
}