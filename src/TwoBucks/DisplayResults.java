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

    public static String[] outputResultsString(User currentUser){
        String testString[] = {
                // Initial Week
                "Initial Week\n", "===================\n",
                "Wage Income: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getWageIncome()) + "\n",
                "Other Income: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getOtherIncome()) + "\n",
                "==========================\n",
                "Total Income: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getTotalIncome()) + "\n",
                "\n",
                "Rent/mortgage: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getRentExpenses()) + "\n",
                "Utilities: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getUtilitiesExpenses()) + "\n",
                "Food: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getFoodExpenses()) + "\n",
                "Travel: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getTravelExpenses()) + "\n",
                "Healthcare: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getHealthcareExpenses()) + "\n",
                "Entertainment: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getEntertainmentExpenses()) + "\n",
                "==========================\n",
                "Total Expenses: " + String.format("%.2f", currentUser.getInitialWeek().getBudget().getTotalExpenses()) + "\n",
                "\n",
                "Net change: $" + String.format("%.2f", currentUser.getInitialWeek().getBudget().getMonthlyNetChange()) + "\n",

                // Previous Week
                "Previous Week\n", "===================\n",
                "Wage Income: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getWageIncome()) + "\n",
                "Other Income: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getOtherIncome()) + "\n",
                "==========================\n",
                "Total Income: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getTotalIncome()) + "\n",
                "\n",
                "Rent/mortgage: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getRentExpenses()) + "\n",
                "Utilities: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getUtilitiesExpenses()) + "\n",
                "Food: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getFoodExpenses()) + "\n",
                "Travel: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getTravelExpenses()) + "\n",
                "Healthcare: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getHealthcareExpenses()) + "\n",
                "Entertainment: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getEntertainmentExpenses()) + "\n",
                "==========================\n",
                "Total Expenses: " + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getTotalExpenses()) + "\n",
                "\n",
                "Net change: $" + String.format("%.2f", currentUser.getPreviousWeek().getBudget().getMonthlyNetChange()),

                // Current Week
                "Initial Week\n", "===================\n",
                "Wage Income: $" + String.format("%.2f", currentUser.getBudget().getWageIncome()) + "\n",
                "Other Income: $" + String.format("%.2f", currentUser.getBudget().getOtherIncome()) + "\n",
                "==========================\n",
                "Total Income: $" + String.format("%.2f", currentUser.getBudget().getTotalIncome()) + "\n",
                "\n",
                "Rent/mortgage: $" + String.format("%.2f", currentUser.getBudget().getRentExpenses()) + "\n",
                "Utilities: $" + String.format("%.2f", currentUser.getBudget().getUtilitiesExpenses()) + "\n",
                "Food: $" + String.format("%.2f", currentUser.getBudget().getFoodExpenses()) + "\n",
                "Travel: $" + String.format("%.2f", currentUser.getBudget().getTravelExpenses()) + "\n",
                "Healthcare: $" + String.format("%.2f", currentUser.getBudget().getHealthcareExpenses()) + "\n",
                "Entertainment: $" + String.format("%.2f", currentUser.getBudget().getEntertainmentExpenses()) + "\n",
                "==========================\n",
                "Total Expenses: " + String.format("%.2f", currentUser.getBudget().getTotalExpenses()) + "\n",
                "\n",
                "Net change: $" + String.format("%.2f", currentUser.getBudget().getMonthlyNetChange())

        };
        return testString;
    }
}

