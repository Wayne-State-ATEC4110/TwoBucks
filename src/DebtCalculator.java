/**
 * File name: DebtCalculator.java
 * Author: Mike Shea
 * Last Edited: 3/21/20
 * This class handles the debt input, calculation, and display for the Two Bucks Application.
 * To use this class, instantiate a DebtCalculator object and call the DebtCalculatorMain() method
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
    private int weeksRemaining;         // Weeks required to pay off debt
    private final int numberOfPeriods = 12; // Number of payment periods
    private int userSelection;
    private boolean firstPass = true;

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

                    CalculateRemainingWeeks();

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

            // Close input stream
            scan.close();

        }
        catch(InputMismatchException e){
            System.out.println("Error: Unrecoverable input encountered.");
        }
        finally{
            System.out.println("Returning to the Two Bucks main menu.");
            System.out.println("=========================================");
        }
    }

    // Display introduction message
    private void DisplayIntroductionMessage(){
        System.out.println("=========================================");
        System.out.println("Welcome to the Two Bucks Debt Calculator.");
    }

    // Display debt calculator menu
    private void DebtCalculatorMenu() {
        System.out.println();
        System.out.println("Please select an option from the menu below:");
        System.out.println("1. Calculate how long it will take to pay off the debt with a given monthly payment.");
        System.out.println("2. Display the debt information again.");
        System.out.println("3. Calculate the monthly interest amount for another debt");
        System.out.println("4. Return to the Two Bucks Main Menu.");
        System.out.println();
    }

    // Receive the debt principal from the user
    private void ReceiveDebtPrincipal() throws InputMismatchException {
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

        scan.nextLine();    // Clear input stream
    }

    // Receive the debt interest rate from the user
    private void ReceiveDebtInterestRate() throws InputMismatchException {
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

        scan.nextLine();    // Clear input stream

    }

    // Receive the monthly payment amount from the user
    private void ReceiveMonthlyPaymentAmount()  throws InputMismatchException {

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

    // Receive user selection from the user for navigating the debt calculator menu
    private void ReceiveUserSelection() throws InputMismatchException {

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

    // Calculate the debt interest amount
    private void CalculateDebtInterestAmount() {

        debtInterestAmount =  (monthlyInterestRate / 100) * debtPrincipal;
    }

    // Display data already entered by the user
    private void DisplayDebt() {
        System.out.println();
        System.out.println("Debt Principal: $" + String.format("%.2f", debtPrincipal));
        System.out.println("Annual Percentage Rate (APR): " + String.format("%.2f", debtInterestRate) + "%");
        System.out.println("Monthly Interest Rate: " + String.format("%.2f", monthlyInterestRate) + "%");
        System.out.println("Interest Paid Monthly: $" + String.format("%.2f", (debtInterestAmount)));
    }

    // Calculate the weeks required to pay off the debt
    private void CalculateRemainingWeeks() {
        if (debtMonthlyPayment <= debtInterestAmount) {
            System.out.println("The monthly payment of " + "$" + debtMonthlyPayment + " is not enough to overcome the monthly interest amount of $" + String.format("%.2f", (debtInterestAmount)));
            System.out.println("Returning to the TwoBucks Debt Calculator main menu.");
        } else {
            // Initialize
            double temporaryDebtCounter = debtPrincipal;
            double temporaryDebtAmount;
            weeksRemaining = 0;

            while (temporaryDebtCounter >= 0) {

                // Calculate this month's interest amount (monthly rate * current total)
                temporaryDebtAmount = temporaryDebtCounter * (monthlyInterestRate / 100);

                // Add interest to account and running total
                temporaryDebtCounter += temporaryDebtAmount;
                totalInterestPaid += temporaryDebtAmount;

                // Apply Payment to tempDebt
                temporaryDebtCounter -= debtMonthlyPayment;

                // Increment week
                weeksRemaining++;

            }

            // Output Results
            this.DisplayRemainingWeeks();

        }

    }

    // Display the weeks remaining until the debt is paid off
    private void DisplayRemainingWeeks(){
        System.out.println("It will take " + weeksRemaining + " weeks to pay off the debt at $" + String.format("%.2f", debtMonthlyPayment) + " per month.");
        System.out.println("Total interest paid: $" + String.format("%.2f", totalInterestPaid));
        System.out.println("Total amount paid: $" + String.format("%.2f", debtPrincipal + totalInterestPaid));
    }

}
