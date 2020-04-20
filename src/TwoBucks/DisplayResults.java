/**
 * <h1>DisplayResults</h1>
 *
 * <p>
 * DisplayResults class outputs initial week, previous week, and current week.
 * It also compares each week to the current week.
 *
 * This class implements the Singleton design pattern
 * </p>
 *
 * @author Mike Shea, Sawyer Kisha
 * @version 1.1
 * @since 4/20/20
 */

package TwoBucks;

public class DisplayResults {

    /**
     * Private static variable
     */
    private static DisplayResults displayResults;


    /**
     * Private constructor
     */
    private DisplayResults(){
        DisplayResults displayResults = new DisplayResults();
    }

    /**
     * Public static method - returns instance of this class
     * @return displayResults
     */

    public static DisplayResults getInstance(){
        return displayResults;
    }

    /**
     * Outputs the currentUser's initial, previous, and current weekly budget
     * @param currentUser
     */
    public static void outputResults(User currentUser){

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

