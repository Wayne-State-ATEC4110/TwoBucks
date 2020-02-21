/*
Two Bucks
DebtCalculator.java
Author: Mike Shea
 */

// todo input verification, format output

import java.util.Scanner;

public class DebtCalculator {

    // private DebtCalculator members
    private Scanner scan = new Scanner(System.in);
    private double debtPrincipal;
    private double debtInterestRate;
    private double debtInterestAmount;
    private double debtMonthlyPayment;
    private int weeksRemaining;
    private int userSelection;
    private boolean firstPass = true;

    public void DebtCalculatorMain() {  // Interface for module

        // Introduction message
        if(firstPass){
            System.out.println("Welcome to the Two Bucks Debt Calculator.");
            firstPass = false;
        }

        // Receive Initial Input
        ReceiveDebtPrinciple();
        ReceiveDebtInterestRate();

        // Calculate and display monthly interest amount
        CalculateDebtInterestAmount();
        DisplayDebt();

        // Present menu and receive user selection
        DebtCalculatorMenu();
        ReceiveUserSelection();

        // Logic flow based on user selection
        switch(userSelection){
            case 1:
                // Calculate how long it will take to pay off the debt with a given monthly payment.
                ReceiveMonthlyPaymentAmount();
                CalculateRemainingWeeks();
                DisplayRemainingWeeks();
                break;
            case 2:
                // Display the debt information already received
                DisplayDebt();
                break;
            case 3:
                // Calculate the monthly interest amount for another debt. (Recursive call)
                DebtCalculatorMain();
                break;
            case 4:
                // Return to the Two Bucks Main Menu
                break;
                //todo: invalid input
            default:
                // Invalid input - Try again
                break;
        }
    }

    // Display debt calculator menu
    private void DebtCalculatorMenu() {
        System.out.println();
        System.out.println("Please select an option from the menu below:");
        System.out.println("1. Calculate how long it will take to pay off the debt with a given monthly payment.");
        System.out.println("2. Calculate the monthly interest amount for another debt");
        System.out.println("3. Return to the Two Bucks Main Menu.");
        System.out.println();
    }

    // Receive user selection from the user for navigating the debt calculator menu
    private void ReceiveUserSelection() {
        userSelection = scan.nextInt();
    }

    // Display data already entered by the user
    private void DisplayDebt() {
        System.out.println("Principal debt: $" + debtPrincipal);
        System.out.println("Interest Rate: " + debtInterestRate + "%");
        System.out.println("Debt Interest Amount: $" + debtInterestAmount);
    }

    // Receive the debt principle from the user
    private void ReceiveDebtPrinciple() {
        System.out.print("Enter the principle of the debt: $");
        debtPrincipal = scan.nextDouble();
    }

    // Receive the monthly payment amount from the user
    private void ReceiveMonthlyPaymentAmount() {
        System.out.print("Enter a monthly payment amount: $");
        debtMonthlyPayment = scan.nextDouble();
    }

    // Receive the debt interest rate from the user
    private void ReceiveDebtInterestRate() {
        System.out.print("Enter the interest rate of the debt as a percentage:");
        debtInterestRate = scan.nextInt();

        // Prevent division by zero
        if(debtInterestRate != 0){
            debtInterestRate /= 100;
        }
    }

    // Calculate the debt interest amount
    private void CalculateDebtInterestAmount() {
        debtInterestAmount =  (debtPrincipal * debtInterestRate);
    }

    // Calculate the weeks required to pay off the debt
    private void CalculateRemainingWeeks() {
        if (debtMonthlyPayment <= debtInterestAmount) {
            System.out.println("The monthly payment of $" + debtMonthlyPayment + " is not enough to cover the monthly interest amount of $" + debtInterestAmount + ".");
        } else {
            double tempDebt = debtPrincipal;
            while (tempDebt >= 0) {

                // Apply Payment to tempDebt
                tempDebt -= debtMonthlyPayment;

                // Calculate new interest amount
                this.CalculateDebtInterestAmount();

                // Add interest to account
                tempDebt += debtInterestAmount;

                weeksRemaining++;

            }
        }

    }

    // Display the weeks remaining until the debt is paid off
    private void DisplayRemainingWeeks(){
        System.out.println("It will take " + weeksRemaining + " weeks to pay off the debt at $" + debtMonthlyPayment + " per month.");
    }

}