/**
 * <h1>Week</h1>
 * The Week class is a subclass of user that holds income of the previous week
 * and initial week for the user to compare with their current progress.
 *
 * <p>
 *
 *
 * @author  Alex Gonzalez
 * @version 1.0
 * @since   03-21-2020
 */

package TwoBucks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Week {

     private double income;
     private double expenses;
     private double saveAmount;
     private double spendAmount;
     private Budget budget;

    /**
     * Default Constructor
     */
    public Week(){
        this.income = 0;
        this.expenses = 0;
        this.saveAmount = 0;
        this.spendAmount = 0;
        this.budget = new Budget();

    }

    /**
     * Constuctor
     * @param income
     * @param expenses
     * @param saveAmount
     * @param spendAmount
     * @param budget
     */
    public Week(double income, double expenses, double saveAmount,
                double spendAmount, Budget budget) {

        this.income = income;
        this.expenses = expenses;
        this.saveAmount = saveAmount;
        this.spendAmount = spendAmount;
        this.budget = budget;
    }

    /**
     *  getIncome method
      * @return income
     */
    public double getIncome() {
        return income;
    }

    /**
     * setIncome method
     * @param income
     */
    public void setIncome(double income) {
        this.income = income;
    }

    /**
     * getExpenses method
     * @return expenses
     */
    public double getExpenses() {
        return expenses;
    }

    /**
     * setExpenses method
     * @param expenses
     */
    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    /**
     * getSaveAmount method
     * @return
     */
    public double getSaveAmount() {
        return saveAmount;
    }

    /**
     * setSaveAmount method
     * @param saveAmount
     */
    public void setSaveAmount(double saveAmount) {
        this.saveAmount = saveAmount;
    }

    /**
     * getSpendAmount method
     * @return
     */
    public double getSpendAmount() {
        return spendAmount;
    }

    /**
     * setSpendAmount
     * @param spendAmount
     */
    public void setSpendAmount(double spendAmount) {
        this.spendAmount = spendAmount;
    }

    /**
     * getBudget method
     * @return budget
     */
    public Budget getBudget() {
        return budget;
    }

    /**
     * setBudget method
     * @param budget
     */
    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    /**
     * copyWeek method, takes user as parameter and copies all
     * the relevant parameters to the week class.
     *
     * @param currentWeek
     */
    public void copyWeek(User currentWeek){
        // Copy all current user parameters from 'currentWeek' to 'previousWeek'
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

    }


    /**
     * toNextWeek copies user variables and saves them to
     * week object previousWeek. Previous week cannot be edited.
     * @param currentWeek
     */
    public void toNextWeek(User currentWeek){

        Scanner scan = new Scanner(System.in);
        int input;

        while(true) {
            try {
                System.out.println("Are you sure you want to Progress to next week?");
                System.out.println("You will not be able to make further edits for this week");
                System.out.println("==========================================================");
                System.out.println("1. Proceed to next week");
                System.out.println("2. Return to main");

                if(scan.hasNextInt()) {
                    input = scan.nextInt();
                }

                else{
                    scan.next();
                    throw new InputMismatchException("Invalid Input");
                }


                if (input == 1) {
                    // Copy all current user parameters from 'currentWeek' to 'previousWeek'
                    this.copyWeek(currentWeek);

                    // Checks if first week
                    if(currentWeek.isFirstWeek()){
                        // Copies initial week if is first week
                        currentWeek.getInitialWeek().copyWeek(currentWeek);
                        // change firstWeek to false
                        currentWeek.setFirstWeek(false);
                    }


                    currentWeek.clearBudget();
                    break;

                    //return currentWeek;
                }
                else if (input == 2) {
                    //return currentWeek;
                    break;

                }
                else {
                    throw new Exception("Invalid Input");
                }
            }
            catch(Exception e){
                System.out.println("Please enter a number 1 or 2\n");
            }
        }


    }

    /**
     * toString method
     */
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
