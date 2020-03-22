/**
 * <h1>Budget</h1>
 *
 * <p>The Budget class allows for a budget to be created or edited after initially created
 * It belongs to the User class.</p>
 *
 * @author Mike Shea
 * @version 1.0
 * @since 3/22/20
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
    private Scanner scan = new Scanner(System.in);

    /**
     * Class toString method used to export class members into one string for saving
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
     */

    public void CreateBudget(){
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
        }
        catch(InputMismatchException e){
            System.out.println("Error: Unrecoverable input entered.");
        }
        finally{
            // Close input stream
            scan.close();
        }
    }

    /**
     * Displays current class members
     */
    private void DisplayBudget() {
        System.out.println("");
        System.out.println("Weekly Budget");
        System.out.println("==========================");
        System.out.println("Total Income: $" + String.format("%.2f", totalIncome));
        System.out.println("Rent/mortgage: $" + String.format("%.2f", rentExpenses));
        System.out.println("Utilities: $" + String.format("%.2f", utilitiesExpenses));
        System.out.println("Food: $" + String.format("%.2f", foodExpenses));
        System.out.println("Travel: $" + String.format("%.2f", travelExpenses));
        System.out.println("Healthcare: $" + String.format("%.2f", healthcareExpenses));
        System.out.println("Entertainment: $" + String.format("%.2f", entertainmentExpenses));
        System.out.println("Net change: $" + String.format("%.2f", monthlyNetChange));
    }

    /**
     * Prompts the user to enter their monthly total income
     * @throws InputMismatchException
     */

    private void ReceiveTotalIncome() throws InputMismatchException {
        System.out.print("Enter your total income from all sources (include all sources of income): $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the total income: $");
            scan.next();
        }

        totalIncome = scan.nextDouble();

        // Validate input - must be positive value
        while(totalIncome <=0 ){
            System.out.print("Invalid input. Please enter a positive numerical value for the total income: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the total income: $");
                scan.next();
            }

            totalIncome = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream
    }

    /**
     * Prompts the user to enter their monthly rent/mortgage payment
     * @throws InputMismatchException
     */
    private void ReceiveRentExpenses() throws InputMismatchException {
        System.out.print("Enter the amount spent on this month's rent/mortgage: $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the rent/mortgage payment: $");
            scan.next();
        }

        rentExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while(rentExpenses <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the rent/mortgage payment: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the rent/mortgage payment: $");
                scan.next();
            }

            rentExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream
    }

    /**
     * Prompts the user to enter their utilities expenses
     * @throws InputMismatchException
     */
    private void ReceiveUtilitiesExpenses() throws InputMismatchException {
        System.out.print("Enter the amount spent on utilities (electric, water, phone, ect): $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the utilities payment: $");
            scan.next();
        }

        utilitiesExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while(utilitiesExpenses <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the utilities payment: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the utilities payment: $");
                scan.next();
            }

            utilitiesExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their food expenses
     * @throws InputMismatchException
     */
    private void ReceiveFoodExpenses() throws InputMismatchException{

        System.out.print("Enter the amount spent on food: $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the food payment: $");
            scan.next();
        }

        foodExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while(foodExpenses <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the food payment: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the food payment: $");
                scan.next();
            }

            foodExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their travel expenses
     * @throws InputMismatchException
     */
    private void ReceiveTravelExpenses() throws InputMismatchException{
        System.out.print("Enter the total spent on travel (car payments/repairs, gasoline, public transport, ect): $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the travel expenses: $");
            scan.next();
        }

        travelExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while(travelExpenses <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the travel expenses: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the travel expenses: $");
                scan.next();
            }

            travelExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their healthcare expenses
     * @throws InputMismatchException
     */
    private void ReceiveHealthcareExpenses() throws InputMismatchException{

        System.out.print("Enter the amount spent on healthcare expenses (including insurance): $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for healthcare expenses: $");
            scan.next();
        }

        healthcareExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while(healthcareExpenses <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the healthcare expenses: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the utilities payment: $");
                scan.next();
            }

            healthcareExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Prompts the user to enter their entertainment expenses
     * @throws InputMismatchException
     */
    private void ReceiveEntertainmentExpenses() throws InputMismatchException{

        System.out.print("Enter the amount spent on entertainment: $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for entertainment expenses: $");
            scan.next();
        }

        entertainmentExpenses = scan.nextDouble();

        // Validate input - must be positive value
        while(entertainmentExpenses <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for entertainment expenses: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for entertainment expenses: $");
                scan.next();
            }

            entertainmentExpenses = scan.nextDouble();
        }

        scan.nextLine();    // Clear input stream

    }

    /**
     * Calculates the monthly net change (income - expenses)
     * @throws InputMismatchException
     */
    private void CalculateMonthlyNetChange() throws InputMismatchException{
        monthlyNetChange = totalIncome - (utilitiesExpenses + foodExpenses
                + travelExpenses + healthcareExpenses + entertainmentExpenses);
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
}