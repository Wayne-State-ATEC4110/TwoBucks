/*
Two Bucks Application
DebtCalculator
 */

import java.util.Scanner;

public class DebtCalculator {

    // Attributes
    private Scanner scan = new Scanner(System.in);
    private double debtPrincipal;
    private double debtInterestRate;
    private double debtInterestAmount;
    private double debtMonthlyPayment;

    // Methods
    void DebtCalculatorMain() {

        // Initial Input & Output
        ReceiveDebtPrinciple();
        ReceiveDebtInterestRate();
        CalculateDebtInterestAmount();
        DisplayDebt();

        DebtCalculatorMenu();
    }

    // todo menu rework
    // todo input verification
    private void DebtCalculatorMenu() {
        int userSelection;
        System.out.println("Debt Calculator Menu");
        System.out.println("=====================");
        System.out.println("Enter the number for the corresponding option and press 'enter'.");
        System.out.println("1. View Debt Principle, Interest Rate, & Monthly Interest Amount.");
        System.out.println("2. Enter a monthly payment to track payments.");
        System.out.println("3. Enter a new debt to track.");
        System.out.println("4. Return to Two Bucks Main Menu.");
        userSelection = scan.nextInt();

        while (userSelection != 4)
            if (userSelection == 1) {

            } else if (userSelection == 2) {

            } else if (userSelection == 3) {

            }
    }

    // todo: format output
    private void DisplayDebt() {
        System.out.println("Principal debt: $" + debtPrincipal);
        System.out.println("Interest Rate: " + debtInterestRate + "%");
        System.out.println("Debt Interest Amount: $" + debtInterestAmount);
    }

    private void ReceiveDebtPrinciple() {
        System.out.println("Enter the principle of the debt:");
        debtPrincipal = scan.nextDouble();
    }

    //todo finish
    private void ReceiveMonthlyPaymentAmount() {
        int weeksRemaining;
        System.out.println("Enter a monthly payment amount: $");
        weeksRemaining = scan.nextInt();

        if (weeksRemaining <= debtMonthlyPayment) {
            System.out.println("The monthly payment of $" + weeksRemaining + " is not enough to cover the monthly interest amount of $" + debtInterestAmount + ".");
        } else {

        }
    }

    private void ReceiveDebtInterestRate() {
        System.out.println("Enter the interest rate of the debt:");
        debtInterestRate = scan.nextDouble();
    }

    // todo: logic
    private void CalculateDebtInterestAmount() {
        debtInterestAmount = debtPrincipal * debtInterestRate;
    }


    void CalculateRemainingWeeks() {


    }

}
