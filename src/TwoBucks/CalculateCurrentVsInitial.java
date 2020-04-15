/**
 * <h>CalculateCurrentVsInitial</h>
 *
 * <p>
 * The CalculateCurrentVsInitial class
 * takes all of the information from the user's
 * current week and all of the information
 * from the user's initial week and subtracts
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

public class CalculateCurrentVsInitial
{
    /**
     *
     * @param currentUser
     */
    public void CurrentVsInitial(User currentUser)
    {
        //Calculating difference
        double income = currentUser.getIncome() - currentUser.getInitialWeek().getIncome();
        double expense = currentUser.getExpenses() - currentUser.getInitialWeek().getExpenses();
        double saveAmount = currentUser.getSaveAmount() - currentUser.getInitialWeek().getSaveAmount();
        double spendAmount = currentUser.getSpendAmount() - currentUser.getInitialWeek().getSpendAmount();

        double totalIncome = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getTotalIncome();
        double wageIncome = currentUser.getBudget().getWageIncome() - currentUser.getInitialWeek().getBudget().getWageIncome();
        double otherIncome = currentUser.getBudget().getOtherIncome() - currentUser.getInitialWeek().getBudget().getOtherIncome();
        double rentExpense = currentUser.getBudget().getRentExpenses() - currentUser.getInitialWeek().getBudget().getRentExpenses();
        double utilitiesExpense = currentUser.getBudget().getUtilitiesExpenses() - currentUser.getInitialWeek().getBudget().getUtilitiesExpenses();
        double foodExpense = currentUser.getBudget().getFoodExpenses() - currentUser.getInitialWeek().getBudget().getFoodExpenses();
        double travelExpense = currentUser.getBudget().getTravelExpenses() - currentUser.getInitialWeek().getBudget().getTravelExpenses();
        double healthCareExpense = currentUser.getBudget().getHealthcareExpenses() - currentUser.getInitialWeek().getBudget().getHealthcareExpenses();
        double entertainmentExpense = currentUser.getBudget().getEntertainmentExpenses() - currentUser.getInitialWeek().getBudget().getEntertainmentExpenses();
        double totalExpense = currentUser.getBudget().getTotalExpenses() - currentUser.getInitialWeek().getBudget().getTotalExpenses();
        double netChange = currentUser.getBudget().getMonthlyNetChange() - currentUser.getInitialWeek().getBudget().getMonthlyNetChange();

        //Outputting difference
        System.out.println("Current vs Initial Difference");
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
        System.out.println("Current vs Initial: ");
        System.out.println("Current Income: $" + currentUser.getIncome() + " Initial Income: $" + currentUser.getInitialWeek().getIncome() + " Difference: $" + income);
        System.out.println("Current Expense: $" + currentUser.getExpenses() + " Initial Expense: $" + currentUser.getInitialWeek().getExpenses() + " Difference: $" + expense);
        System.out.println("Current Save Amount: $" + currentUser.getSaveAmount() + " Initial Save Amount: $" + currentUser.getInitialWeek().getSaveAmount() + " Difference: $" + saveAmount);
        System.out.println("Current Spend Amount: $" + currentUser.getSpendAmount() + "Initial Spend Amount: $" + currentUser.getInitialWeek().getSpendAmount() + " Difference: $" + spendAmount);

        System.out.println("Current Total Income: $" + currentUser.getBudget().getTotalIncome() + " Initial Total Income: $" + currentUser.getInitialWeek().getBudget().getTotalIncome() + " Difference: $" + totalIncome);
        System.out.println("Current Wage Income: $" + currentUser.getBudget().getWageIncome() + " Initial Wage Income: $" + currentUser.getInitialWeek().getBudget().getWageIncome() + " Difference: $"+ wageIncome);
        System.out.println("Current Other Income: $" + currentUser.getBudget().getOtherIncome() + " Initial Other Income: $" + currentUser.getInitialWeek().getBudget().getOtherIncome() + " Difference: $" + otherIncome);
        System.out.println("Current Rent Expense: $" + currentUser.getBudget().getRentExpenses() + " Initial Rent Expense: $" + currentUser.getInitialWeek().getBudget().getRentExpenses() + " Difference: $" + rentExpense);
        System.out.println("Current Utilities Expense: $" + currentUser.getBudget().getUtilitiesExpenses() + " Initial Utilities Expense: $" + currentUser.getInitialWeek().getBudget().getUtilitiesExpenses() + " Difference: $" + utilitiesExpense);
        System.out.println("Current Food Expense: $" + currentUser.getBudget().getFoodExpenses() + " Initial Food Expense: $" + currentUser.getInitialWeek().getBudget().getFoodExpenses() + " Difference: $" + foodExpense);
        System.out.println("Current Travel Expense: $" + currentUser.getBudget().getTravelExpenses() + " Initial Travel Expense: $" + currentUser.getInitialWeek().getBudget().getTravelExpenses() + " Difference: $" + travelExpense);
        System.out.println("Current HealthCare Expense: $" + currentUser.getBudget().getHealthcareExpenses() + " Initial HealthCare Expense: $" + currentUser.getInitialWeek().getBudget().getHealthcareExpenses() + " Difference: $" + healthCareExpense);
        System.out.println("Current Entertainment Expense: $" + currentUser.getBudget().getEntertainmentExpenses() + " Initial Entertainment Expense: $" + currentUser.getInitialWeek().getBudget().getEntertainmentExpenses() + " Difference: $" + entertainmentExpense);
        System.out.println("Current Total Expense: $" + currentUser.getBudget().getTotalExpenses() + " Initial Total Expense: $" + currentUser.getInitialWeek().getBudget().getTotalExpenses() + " Difference: $" + totalExpense);
        System.out.println("Current Net Change: $" + currentUser.getBudget().getMonthlyNetChange() + " Initial Net Change: $" + currentUser.getInitialWeek().getBudget().getMonthlyNetChange() + " Difference: $" + netChange);
        */
    }
}
