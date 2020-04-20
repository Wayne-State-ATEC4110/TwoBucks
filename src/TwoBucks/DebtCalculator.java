/**
 * <h1>DebtCalculator</h1>
 *
 * <p>The DebtCalculator class allows a user to enter a debt principle and interest rate. It then
 * allows the user to enter a monthly payment amount and calculates how many months it will take
 * to pay off the debt.</p>
 *
 * @author Mike Shea
 * @version 1.0
 * @since 3/22/20
 */


package TwoBucks;

import java.util.*;

public class DebtCalculator {

    // private DebtCalculator members
    private Scanner scan = new Scanner(System.in);
    private double debtPrincipal;       // Principal value of debt
    private double debtInterestRate;    // Debt interest rate (APR)
    private double monthlyInterestRate; // Monthly interest rate (APR / periods)
    private double debtInterestAmount;  // Amount paid each month in interest
    private double debtMonthlyPayment;  // Amount to be paid against the debt each month
    private double totalInterestPaid;   // Total amount paid in interest
    private int monthsRemaining;         // Months required to pay off debt
    private final int numberOfPeriods = 12; // Number of payment periods
    private int userSelection;
    private boolean firstPass = true;

    /**
     * Main method for DebtCalculator class. Calling this method from an outside scope
     * will allow the DebtCalculator class to run, perform all necessary functions, and then stop.
     */
    public void DebtCalculatorMain() {  // Interface for module

        if(firstPass){
            DisplayIntroductionMessage();
            firstPass = false;
        }

        try {
            // Receive Initial Input
            ReceiveDebtPrincipal();
            ReceiveDebtInterestRate();

            // Calculate and display monthly interest amount
            CalculateDebtInterestAmount();
            DisplayDebt();

            // Present menu and receive user selection
            DebtCalculatorMenu();
            ReceiveUserSelection();


            while (userSelection != 4) {
                if (userSelection == 1) {
                    // Calculate how long it will take to pay off the debt with a given monthly payment. //
                    ReceiveMonthlyPaymentAmount();

                    CalculateRemainingMonths();

                    // Menu and user input
                    DebtCalculatorMenu();
                    ReceiveUserSelection();
                } else if (userSelection == 2) {
                    // Display the debt information already received
                    DisplayDebt();

                    // Menu and user input
                    DebtCalculatorMenu();
                    ReceiveUserSelection();
                } else if (userSelection == 3) {
                    // Calculate the monthly interest amount for another debt
                    ReceiveDebtPrincipal();
                    ReceiveDebtInterestRate();

                    // Calculate and display monthly interest amount
                    CalculateDebtInterestAmount();
                    DisplayDebt();

                    // Present menu and receive user selection
                    DebtCalculatorMenu();
                    ReceiveUserSelection();

                } else {
                    System.out.println("Invalid input.");
                    ReceiveUserSelection();
                }

            }


        }
        catch(InputMismatchException e){
            System.out.println("Error: Unrecoverable input encountered.");
            userSelection = 4;
        }
        finally{
            System.out.println("Returning to the Two Bucks main menu.");
            System.out.println("=========================================");
        }
    }

    /**
     * Displays introduction message before entering a debt for the first time (for this instance of the class)
     */
    private void DisplayIntroductionMessage(){
        System.out.println("=========================================");
        System.out.println("Welcome to the Two Bucks Debt Calculator.");
    }

    /**
     * Displays a menu with options for the user to select from.
     */
    private void DebtCalculatorMenu() {
        System.out.println();
        System.out.println("Please select an option from the menu below:");
        System.out.println("1. Calculate how long it will take to pay off the debt with a given monthly payment.");
        System.out.println("2. Display the debt information again.");
        System.out.println("3. Calculate the monthly interest amount for another debt");
        System.out.println("4. Return to the Two Bucks Main Menu.");
        System.out.println();
    }

    /**
     * Prompts the user to enter a debt principal. Only accepts positive doubles.
     * @throws InputMismatchException
     */
    public void ReceiveDebtPrincipal() throws InputMismatchException {
        System.out.print("Enter the principal of the debt: $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the debt principal: $");
            scan.next();
        }

        debtPrincipal = scan.nextDouble();

        // Validate input - must be positive value
        while(debtPrincipal <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the debt principal: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the debt principal: $");
                scan.next();
            }

            debtPrincipal = scan.nextDouble();
        }

    }

    /**
     * Prompts the user to enter an annual interest rate (APR). Only accepts positive doubles.
     * @throws InputMismatchException
     */
    // Receive the debt interest rate from the user
    public void ReceiveDebtInterestRate() throws InputMismatchException {
        System.out.print("Enter the annual percentage rate (APR) of the debt: ");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the APR: ");
            scan.next();
        }

        debtInterestRate = scan.nextDouble();

        // Validate input - must be positive value
        while(debtInterestRate <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the APR: ");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the APR: ");
                scan.next();
            }

            debtInterestRate = scan.nextDouble();
        }

        // Formula for monthly interest rate = (principal / periods) / 100
        monthlyInterestRate = debtInterestRate / numberOfPeriods;


    }

    /**
     * Prompts the user to enter a monthly payment amount. Only accepts positive doubles.
     * @throws InputMismatchException
     */
    // Receive the monthly payment amount from the user
    public void ReceiveMonthlyPaymentAmount()  throws InputMismatchException {

        System.out.print("Enter a monthly payment amount: $");

        // Validate Input - must be Double type
        while(!scan.hasNextDouble()){
            System.out.print("Invalid input. Please enter a numerical value for the monthly payment amount: $");
            scan.next();
        }

        debtMonthlyPayment = scan.nextDouble();

        // Validate input - must be positive value
        while(debtMonthlyPayment <=0){
            System.out.print("Invalid input. Please enter a positive numerical value for the monthly payment amount: $");

            // Validate Input - must be Double type
            while(!scan.hasNextDouble()){
                System.out.print("Invalid input. Please enter a numerical value for the monthly payment amount: $");
                scan.next();
            }

            debtMonthlyPayment = scan.nextDouble();
        }

    }

    /**
     * Prompts the user to make a selection from the menu. Must be an integer between 1 and 4 (inclusive)
     * @throws InputMismatchException
     */
    // Receive user selection from the user for navigating the debt calculator menu
    public void ReceiveUserSelection() throws InputMismatchException {

        int temporarySelection = 0;

        // Must in an integer
        while(!scan.hasNextInt()){
            System.out.print("Invalid input. Please enter a valid numerical option as shown in the menu.");
            scan.next();
        }

        temporarySelection = scan.nextInt();

        while(temporarySelection <= 0 || temporarySelection >4){
            System.out.print("Invalid input. Please enter a valid numerical option as shown in the menu.");

            while(!scan.hasNextInt()){
                System.out.print("Invalid input. Please enter a valid numerical option as shown in the menu.");
                scan.next();
            }

            temporarySelection = scan.nextInt();
        }

        userSelection = temporarySelection;
    }

    /**
     * Calculates the monthly amount paid in interest
     */
    // Calculate the debt interest amount
    public void CalculateDebtInterestAmount() {

        debtInterestAmount =  (monthlyInterestRate / 100) * debtPrincipal;
    }

    /**
     * Displays the current debt information held by the class
     */
    private void DisplayDebt() {
        System.out.println();
        System.out.println("Debt Principal: $" + String.format("%.2f", debtPrincipal));
        System.out.println("Annual Percentage Rate (APR): " + String.format("%.2f", debtInterestRate) + "%");
        System.out.println("Monthly Interest Rate: " + String.format("%.2f", monthlyInterestRate) + "%");
        System.out.println("Interest Paid Monthly: $" + String.format("%.2f", (debtInterestAmount)));
    }

    /**
     * Calculates the months remaining until the debt will be paid with current debt information
     * held by the class.
     */
    public void CalculateRemainingMonths() {
        if (debtMonthlyPayment <= debtInterestAmount) {
            System.out.println("The monthly payment of " + "$" + debtMonthlyPayment + " is not enough to overcome the monthly interest amount of $" + String.format("%.2f", (debtInterestAmount)));
            System.out.println("Returning to the TwoBucks Debt Calculator main menu.");
        } else {
            // Initialize
            double temporaryDebtCounter = debtPrincipal;
            double temporaryDebtAmount;
            monthsRemaining = 0;

            while (temporaryDebtCounter >= 0) {

                // Calculate this month's interest amount (monthly rate * current total)
                temporaryDebtAmount = temporaryDebtCounter * (monthlyInterestRate / 100);

                // Add interest to account and running total
                temporaryDebtCounter += temporaryDebtAmount;
                totalInterestPaid += temporaryDebtAmount;

                // Apply Payment to tempDebt
                temporaryDebtCounter -= debtMonthlyPayment;

                // Increment month
                monthsRemaining++;

            }

            // Output Results
            this.DisplayRemainingMonths();

        }

    }

    /**
     * Displays the months remaining until the debt will be paid with current debt information
     * held by the class.
     */
    private void DisplayRemainingMonths(){
        System.out.println("It will take " + monthsRemaining + " months to pay off the debt at $" + String.format("%.2f", debtMonthlyPayment) + " per month.");
        System.out.println("Total interest paid: $" + String.format("%.2f", totalInterestPaid));
        System.out.println("Total amount paid: $" + String.format("%.2f", debtPrincipal + totalInterestPaid));
    }

    // Getters and Setters


    /**
     * @return debtPrincipal double
     */
    public double getDebtPrincipal() {
        return debtPrincipal;
    }

    /**
     * @param debtPrincipal
     */
    public void setDebtPrincipal(double debtPrincipal) {
        this.debtPrincipal = debtPrincipal;
    }

    /**
     * @return debtInterestRate double
     */
    public double getDebtInterestRate() {
        return debtInterestRate;
    }

    /**
     * @param debtInterestRate
     */
    public void setDebtInterestRate(double debtInterestRate) {
        this.debtInterestRate = debtInterestRate;
    }

    /**
     * @return monthlyInterestRate double
     */
    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    /**
     * @param monthlyInterestRate
     */
    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    /**
     * @return debtInterestAmount double
     */
    public double getDebtInterestAmount() {
        return debtInterestAmount;
    }

    /**
     * @param debtInterestAmount
     */
    public void setDebtInterestAmount(double debtInterestAmount) {
        this.debtInterestAmount = debtInterestAmount;
    }

    /**
     * @return debtMonthlyPayment
     */
    public double getDebtMonthlyPayment() {
        return debtMonthlyPayment;
    }

    /**
     * @param debtMonthlyPayment
     */
    public void setDebtMonthlyPayment(double debtMonthlyPayment) {
        this.debtMonthlyPayment = debtMonthlyPayment;
    }

    /**
     * @return totalInterestPaid double
     */
    public double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    /**
     * @param totalInterestPaid
     */
    public void setTotalInterestPaid(double totalInterestPaid) {
        this.totalInterestPaid = totalInterestPaid;
    }

    /**
     * @return monthsRemaining int
     */
    public int getMonthsRemaining() {
        return monthsRemaining;
    }

    /**
     * @param monthsRemaining
     */
    public void setMonthsRemaining(int monthsRemaining) {
        this.monthsRemaining = monthsRemaining;
    }

    /**
     * @return numberOfPeriods int
     */
    public int getNumberOfPeriods() {
        return numberOfPeriods;
    }

    /**
     * @return userSelection int
     */
    public int getUserSelection(){
        return userSelection;
    }
}
