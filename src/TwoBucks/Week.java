/**
 * <h1>Week</h1>
 * The DisplayGoals class prints to the screen the user's current saving
 * and spending goals and their current progress toward those goals.
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


    private User previousWeek;


    Week(){
        this.previousWeek = new User();

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
                previousWeek.setFirstName(currentWeek.getFirstName());          // first name
                previousWeek.setLastName(currentWeek.getLastName());            // last name
                previousWeek.setEmail(currentWeek.getEmail());                  // email
                previousWeek.setIncome(currentWeek.getIncome());                // income
                previousWeek.setSaveAmount(currentWeek.getSaveAmount());        // saveAmount
                previousWeek.setSpendAmount(currentWeek.getSpendAmount());      // spendAmount

                // copy budget parameters
                previousWeek.setBudget(currentWeek.getBudget());
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



    /**
     * previousWeek setter method
     *
     * @param previousWeek
     */
    public void setPreviousWeek(User previousWeek) {
        this.previousWeek = previousWeek;

    }

    /**
     * previousWeek getter method
     *
     * @return previousWeek
     */
    public User getPreviousWeek() {
        return this.previousWeek;
    }

    @Override
    public String toString() {
        return this.getPreviousWeek().toString();
    }
}
