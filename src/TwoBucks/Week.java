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

public class Week {

    private User currentWeek = new User();
    private User previousWeek = new User();

    // progress to next week copies user variables and saves them to
    // new User object previousWeek. Previous week cannot be edited.
    public void toNextWeek(User currentWeek){

        // Copy all current user parameters from 'currentWeek' to 'previousWeek'
        previousWeek.setFirstName(currentWeek.getFirstName());          // first name
        previousWeek.setLastName(currentWeek.getLastName());            // last name
        previousWeek.setEmail(currentWeek.getEmail());                  // email
        previousWeek.setIncome(currentWeek.getIncome());                // income
        previousWeek.setSaveAmount(currentWeek.getSaveAmount());        // saveAmount
        previousWeek.setSpendAmount(currentWeek.getSpendAmount());      // spendAmount

        // copy budget parameters


        // Reset all expenses and weekly savings in current week


    }


    /**
     * currentWeek setter method
     *
     * @param currentWeek
     */
    public void setCurrentWeek(User currentWeek) {
        this.currentWeek = currentWeek;

    }

    /**
     * currentWeek getter method
     *
     * @return currentWeek
     */
    public User getCurrentWeek(){
        return this.currentWeek;

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
}