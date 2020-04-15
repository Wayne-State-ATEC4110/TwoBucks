/**
 * <h1>Week</h1>
 * The Week class is a subclass of user that holds another user class and
 *
 * <p>
 *
 *
 * @author  Alex Gonzalez
 * @version 1.0
 * @since   03-21-2020
 */

package TwoBucks;

import java.util.Scanner;

public class Week {

     private double income;
     private double expenses;
     private double saveAmount;
     private double spendAmount;
     private Budget budget;




    public Week(){
        this.income = 0;
        this.expenses = 0;
        this.saveAmount = 0;
        this.spendAmount = 0;
        this.budget = new Budget();

    }

    public Week(double income, double expenses, double saveAmount,
                double spendAmount, Budget budget) {

        this.income = income;
        this.expenses = expenses;
        this.saveAmount = saveAmount;
        this.spendAmount = spendAmount;
        this.budget = budget;    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getSaveAmount() {
        return saveAmount;
    }

    public void setSaveAmount(double saveAmount) {
        this.saveAmount = saveAmount;
    }

    public double getSpendAmount() {
        return spendAmount;
    }

    public void setSpendAmount(double spendAmount) {
        this.spendAmount = spendAmount;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    // progress to next week copies user variables and saves them to
    // new User object previousWeek. Previous week cannot be edited.
    public User toNextWeek(User currentWeek){

        Scanner scan = new Scanner(System.in);
        int input;

        while(true) {


            System.out.println("Are you sure you want to Progress to next week?");
            System.out.println("You will not be able to make further edits for this week");
            System.out.println("==========================================================");
            System.out.println("1. Proceed to next week");
            System.out.println("2. Return to main");
            input = scan.nextInt();


            if(input == 1) {
                // Copy all current user parameters from 'currentWeek' to 'previousWeek'
                //previousWeek.setFirstName(currentWeek.getFirstName());          // first name
                //previousWeek.setLastName(currentWeek.getLastName());            // last name
                //previousWeek.setEmail(currentWeek.getEmail());                  // email
                this.setIncome(currentWeek.getIncome());                // income
                this.setExpenses(currentWeek.getExpenses());
                this.setSaveAmount(currentWeek.getSaveAmount());        // saveAmount
                this.setSpendAmount(currentWeek.getSpendAmount());      // spendAmount

                // copy budget parameters
                this.getBudget().setTotalIncome(currentWeek.getBudget().getTotalIncome());
                this.getBudget().setWageIncome(currentWeek.getBudget().getWageIncome());
                this.getBudget().setOtherIncome(currentWeek.getBudget().getOtherIncome());
                this.getBudget().setRentExpenses(currentWeek.getBudget().getRentExpenses());
                this.getBudget().setUtilitiesExpenses(currentWeek.getBudget().getUtilitiesExpenses());
                this.getBudget().setFoodExpenses(currentWeek.getBudget().getFoodExpenses());
                this.getBudget().setTravelExpenses(currentWeek.getBudget().getTravelExpenses());
                this.getBudget().setHealthcareExpenses(currentWeek.getBudget().getHealthcareExpenses());
                this.getBudget().setEntertainmentExpenses(currentWeek.getBudget().getEntertainmentExpenses());
                this.getBudget().setTotalExpenses(currentWeek.getBudget().getTotalExpenses());
                this.getBudget().setMonthlyNetChange(currentWeek.getBudget().getMonthlyNetChange());


                currentWeek.clearBudget();

                return currentWeek;
            }
            else if (input ==2 ){
                return currentWeek;

            }
            else{
                System.out.println("Invalid Input");
            }
        }


    }


    @Override
    public String toString() {
        return this.income +
                ", " + this.expenses +
                ", " + this.saveAmount +
                ", " + this.spendAmount +
                ", " + this.getBudget().toString()
                ;
    }
}