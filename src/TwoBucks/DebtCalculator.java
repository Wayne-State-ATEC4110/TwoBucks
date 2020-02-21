/*
Two Bucks
DebtCalculator.java
Author: Mike Shea

To access the DebtCalculator from an outside scope,
simply initialize a DebtCalculator object (no args)
and call the DebtCalculatorMain() method on it.

 */

import java.util.Scanner;


public class DebtCalculator {

    // private DebtCalculator members
    private Scanner scan = new Scanner(System.in);
    private double debtPrincipal;
    private double debtInterestRate;
    private double monthlyInterestRate;
    private double debtInterestAmount;
    private double debtMonthlyPayment;
    private double totalInterestPaid;
    private int weeksRemaining;
    private int userSelection;
    private final int numberOfPeriods = 12; // Number of payment periods
    private boolean firstPass = true;

    public void DebtCalculatorMain() {  // Interface for module

        if(firstPass){
            DisplayIntroductionMessage();
            firstPass = false;
        }

        // Receive Initial Input
        ReceiveDebtPrincipal();
        ReceiveDebtInterestRate();

        // Calculate and display monthly interest amount
        CalculateDebtInterestAmount();
        DisplayDebt();

        // Present menu and receive user selection
        DebtCalculatorMenu();
        ReceiveUserSelection();

        while(userSelection != 4){
            if(userSelection == 1){
                // Calculate how long it will take to pay off the debt with a given monthly payment. //
                ReceiveMonthlyPaymentAmount();
                CalculateRemainingWeeks();

                // Menu and user input
                DebtCalculatorMenu();
                ReceiveUserSelection();
            }
            else if(userSelection == 2){
                // Display the debt information already received
                DisplayDebt();

                // Menu and user input
                DebtCalculatorMenu();
                ReceiveUserSelection();
            }
            else if(userSelection == 3){
                // Calculate the monthly interest amount for another debt
                ReceiveDebtPrincipal();
                ReceiveDebtInterestRate();

                // Calculate and display monthly interest amount
                CalculateDebtInterestAmount();
                DisplayDebt();

                // Present menu and receive user selection
                DebtCalculatorMenu();
                ReceiveUserSelection();

            }

        }

        // Close input stream
        scan.close();

        System.out.println("Returning to the Two Bucks main menu.");
        System.out.println("=========================================");
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
    private void ReceiveDebtPrincipal() {
        System.out.print("Enter the principal of the debt: $");

        // Validate input
        while (!scan.hasNextDouble()){  // Must be Double type
            System.out.print("Invalid input. Enter the principal of the debt: $");
            scan.nextLine();    // Disregard bad input
        }

        debtPrincipal = scan.nextDouble();
        scan.nextLine();    // Clear input stream
    }

    // Receive the debt interest rate from the user
    private void ReceiveDebtInterestRate() {
        System.out.print("Enter the annual percentage rate (APR) of the debt: ");

        // Validate Input
        while (!scan.hasNextDouble()){  // Must be Double type
            System.out.print("Invalid input. Enter the annual percentage rate (APR) of the debt: ");
            scan.nextLine();    // Ignore bad input
            }

        debtInterestRate = scan.nextDouble();

        // Formula for monthly interest rate = (principal / periods) / 100
        monthlyInterestRate = debtInterestRate / numberOfPeriods;
        monthlyInterestRate /= 100;

        scan.nextLine();    // Clear input stream

    }

    // Receive the monthly payment amount from the user
    private void ReceiveMonthlyPaymentAmount() {
        System.out.print("Enter a monthly payment amount: $");

        // Validate input
        while (!scan.hasNextDouble()){  // Must be Double type
            System.out.print("Invalid input. Enter the monthly payment amount: $");
            scan.nextLine();    // Disregard bad input
        }

        debtMonthlyPayment = scan.nextDouble();
    }

    // Receive user selection from the user for navigating the debt calculator menu
    private void ReceiveUserSelection() {

        // Validate input
        while(!scan.hasNextInt()){  // must be integer
            System.out.println("Invalid input.");
            DebtCalculatorMenu();
            scan.nextLine(); // Ignore bad input
        }
        while(scan.nextInt() < 1 || scan.nextInt() > 4){
            System.out.println("Invalid input.");
            DebtCalculatorMenu();
            scan.nextLine(); // Ignore bad input
        }

        userSelection = scan.nextInt();
        scan.nextLine(); // Clear stream
    }

    // Calculate the debt interest amount
    private void CalculateDebtInterestAmount() {

        debtInterestAmount =  monthlyInterestRate * debtPrincipal;
    }

    // Display data already entered by the user
    private void DisplayDebt() {
        System.out.println();
        System.out.println("Debt Principal: $" + String.format("%.2f", debtPrincipal));
        System.out.println("Annual Percentage Rate (APR): " + String.format("%.2f", debtInterestRate) + "%");
        System.out.println("Monthly Interest Rate: " + String.format("%.4f", monthlyInterestRate) + "%");
        System.out.println("Interest Paid Monthly: $" + String.format("%.2f", (debtInterestAmount)));
    }

    // Calculate the weeks required to pay off the debt
    private void CalculateRemainingWeeks() {
        if (debtMonthlyPayment <= debtInterestAmount) {
            System.out.println("The monthly payment of $" + debtMonthlyPayment + " is not enough to cover the monthly interest amount of $" + debtInterestAmount + ".");
        } else {
            double temporaryDebtCounter = debtPrincipal;
            weeksRemaining = 0;

            while (temporaryDebtCounter >= 0) {

                // Apply Payment to tempDebt
                temporaryDebtCounter -= debtMonthlyPayment;

                // Calculate this month's interest amount (monthly rate * current total)
                double temporaryDebtAmount = temporaryDebtCounter * monthlyInterestRate;

                // Add interest to account and running total
                temporaryDebtCounter += temporaryDebtAmount;
                totalInterestPaid += temporaryDebtAmount;

                // Increment week
                weeksRemaining++;

                //Display results
                DisplayRemainingWeeks();
            }

        }

    }

    // Display the weeks remaining until the debt is paid off
    private void DisplayRemainingWeeks(){
        System.out.println("It will take " + weeksRemaining + " weeks to pay off the debt at $" + String.format("%.2f", debtMonthlyPayment) + " per month.");
        System.out.println("Total interest paid: $" + String.format("%.2f", totalInterestPaid));
        System.out.println("Total amount paid: $" + String.format("%.2f", debtPrincipal + totalInterestPaid));
    }

}