/**
 * <h1>DisplayResults</h1>
 *
 * <p>
 * DisplayResults class outputs initial week, previous week, and current week.
 * It also compares each week to the current week.
 * </p>
 *
 * @author Mike Shea, Sawyer Kisha
 * @version 1.1
 * @since 4/20/20
 */

package TwoBucks;

public class DisplayResults {

    /**
     * Outputs the currentUser's initial, previous, and current weekly budget
     * @param currentUser
     */
    public void outputResults(User currentUser){

        System.out.println("Initial Week");
        System.out.println("===================");
        currentUser.getInitialWeek().getBudget().DisplayBudget();
        System.out.println("");
        CalculateCurrentVsInitial calculateCurrentVsInitial = new CalculateCurrentVsInitial();
        calculateCurrentVsInitial.CurrentVsInitial(currentUser);
        System.out.println("");

        System.out.println("Previous Week");
        System.out.println("===================");
        currentUser.getPreviousWeek().getBudget().DisplayBudget();
        System.out.println("");
        CalculateCurrentVsPrevious calculateCurrentVsPrevious = new CalculateCurrentVsPrevious();
        calculateCurrentVsPrevious.CurrentVsPrevious(currentUser);
        System.out.println("");

        System.out.println("Current Week");
        System.out.println("===================");
        currentUser.getBudget().DisplayBudget();
    }
}

