/**
 * <h>CalculateCurrentVsPrevious</h>
 *
 * <p>
 * The CalculateCurrentVsPrevious class
 * takes all of the information from the user's
 * current week and all of the information
 * from the user's previous week and subtracts
 * the data in order to find the difference.
 * This difference is then outputted in order
 * to be called in the DisplayResults class
 * </p>
 *
 * @author  Sawyer Kisha
 * @version 1.0
 * @since   1.0
 */

package TwoBucks;

public class CalculateCurrentVsPrevious
{
    /**
     *  This method calculates the difference between the current
     *  data verses the previous data using subtraction. Then prints
     *  the difference.
     * @param currentUser
     */
    public void CurrentVsPrevious(User currentUser)
    {
        //Calculating difference
        double income = currentUser.getIncome() - currentUser.getPreviousWeek().getIncome();
        double expense = currentUser.getExpenses() - currentUser.getPreviousWeek().getExpenses();
        double saveAmount = currentUser.getSaveAmount() - currentUser.getPreviousWeek().getSaveAmount();
        double spendAmount = currentUser.getSpendAmount() - currentUser.getPreviousWeek().getSpendAmount();

        double totalIncome = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getTotalIncome();
        double wageIncome = currentUser.getBudget().getWageIncome() - currentUser.getPreviousWeek().getBudget().getWageIncome();
        double otherIncome = currentUser.getBudget().getOtherIncome() - currentUser.getPreviousWeek().getBudget().getOtherIncome();
        double rentExpense = currentUser.getBudget().getRentExpenses() - currentUser.getPreviousWeek().getBudget().getRentExpenses();
        double utilitiesExpense = currentUser.getBudget().getUtilitiesExpenses() - currentUser.getPreviousWeek().getBudget().getUtilitiesExpenses();
        double foodExpense = currentUser.getBudget().getFoodExpenses() - currentUser.getPreviousWeek().getBudget().getFoodExpenses();
        double travelExpense = currentUser.getBudget().getTravelExpenses() - currentUser.getPreviousWeek().getBudget().getTravelExpenses();
        double healthCareExpense = currentUser.getBudget().getHealthcareExpenses() - currentUser.getPreviousWeek().getBudget().getHealthcareExpenses();
        double entertainmentExpense = currentUser.getBudget().getEntertainmentExpenses() - currentUser.getPreviousWeek().getBudget().getEntertainmentExpenses();
        double totalExpense = currentUser.getBudget().getTotalExpenses() - currentUser.getPreviousWeek().getBudget().getTotalExpenses();
        double netChange = currentUser.getBudget().getMonthlyNetChange() - currentUser.getPreviousWeek().getBudget().getMonthlyNetChange();

        //Outputting difference
        System.out.println("Current vs Previous Difference");
        System.out.println("===================");
        System.out.println("Current Income Difference: $" + income);
        System.out.println("Current Expense Difference: $" + expense);
        System.out.println("Current Save Amount Difference: $" + saveAmount);
        System.out.println("Current Spend Amount Difference: $" + spendAmount);

        System.out.println("Current Total Income Difference: $" + totalIncome);
        System.out.println("Current Wage Income Difference: $" + wageIncome);
        System.out.println("Current Other Income Difference: $" + otherIncome);
        System.out.println("Current Rent Expense Difference: $" + rentExpense);
        System.out.println("Current Utilities Expense Difference: $" + utilitiesExpense);
        System.out.println("Current Food Expense Difference: $" + foodExpense);
        System.out.println("Current Travel Expense Difference: $" + travelExpense);
        System.out.println("Current HealthCare Expense Difference: $" + healthCareExpense);
        System.out.println("Current Entertainment Expense Difference: $" + entertainmentExpense);
        System.out.println("Current Total Expense Difference: $" +  totalExpense);
        System.out.println("Current Net Change Difference: $" + netChange);

        /*
        System.out.println("Current vs Previous: ");
        System.out.println("Current Income: $" + currentUser.getIncome() + " Previous Income: $" + currentUser.getPreviousWeek().getIncome() + " Difference: $" + income);
        System.out.println("Current Expense: $" + currentUser.getExpenses() + " Previous Expense: $" + currentUser.getPreviousWeek().getExpenses() + " Difference: $" + expense);
        System.out.println("Current Save Amount: $" + currentUser.getSaveAmount() + " Previous Save Amount: $" + currentUser.getPreviousWeek().getSaveAmount() + " Difference: $" + saveAmount);
        System.out.println("Current Spend Amount: $" + currentUser.getSpendAmount() + "Previous Spend Amount: $" + currentUser.getPreviousWeek().getSpendAmount() + " Difference: $" + spendAmount);

        System.out.println("Current Total Income: $" + currentUser.getBudget().getTotalIncome() + " Previous Total Income: $" + currentUser.getPreviousWeek().getBudget().getTotalIncome() + " Difference: $" + totalIncome);
        System.out.println("Current Wage Income: $" + currentUser.getBudget().getWageIncome() + " Previous Wage Income: $" + currentUser.getPreviousWeek().getBudget().getWageIncome() + " Difference: $"+ wageIncome);
        System.out.println("Current Other Income: $" + currentUser.getBudget().getOtherIncome() + " Previous Other Income: $" + currentUser.getPreviousWeek().getBudget().getOtherIncome() + " Difference: $" + otherIncome);
        System.out.println("Current Rent Expense: $" + currentUser.getBudget().getRentExpenses() + " Previous Rent Expense: $" + currentUser.getPreviousWeek().getBudget().getRentExpenses() + " Difference: $" + rentExpense);
        System.out.println("Current Utilities Expense: $" + currentUser.getBudget().getUtilitiesExpenses() + " Previous Utilities Expense: $" + currentUser.getPreviousWeek().getBudget().getUtilitiesExpenses() + " Difference: $" + utilitiesExpense);
        System.out.println("Current Food Expense: $" + currentUser.getBudget().getFoodExpenses() + " Previous Food Expense: $" + currentUser.getPreviousWeek().getBudget().getFoodExpenses() + " Difference: $" + foodExpense);
        System.out.println("Current Travel Expense: $" + currentUser.getBudget().getTravelExpenses() + " Previous Travel Expense: $" + currentUser.getPreviousWeek().getBudget().getTravelExpenses() + " Difference: $" + travelExpense);
        System.out.println("Current HealthCare Expense: $" + currentUser.getBudget().getHealthcareExpenses() + " Previous HealthCare Expense: $" + currentUser.getPreviousWeek().getBudget().getHealthcareExpenses() + " Difference: $" + healthCareExpense);
        System.out.println("Current Entertainment Expense: $" + currentUser.getBudget().getEntertainmentExpenses() + " Previous Entertainment Expense: $" + currentUser.getPreviousWeek().getBudget().getEntertainmentExpenses() + " Difference: $" + entertainmentExpense);
        System.out.println("Current Total Expense: $" + currentUser.getBudget().getTotalExpenses() + " Previous Total Expense: $" + currentUser.getPreviousWeek().getBudget().getTotalExpenses() + " Difference: $" + totalExpense);
        System.out.println("Current Net Change: $" + currentUser.getBudget().getMonthlyNetChange() + " Previous Net Change: $" + currentUser.getPreviousWeek().getBudget().getMonthlyNetChange() + " Difference: $" + netChange);
        */
    }
}
