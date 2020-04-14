/**
 * <h>CalculateCurrentVsPrevious</h>
 *
 * <p>
 *
 *
 * </p>
 *
 * @author  Sawyer Kisha
 * @version 1.0
 * @since   1.0
 */

package TwoBucks;

//Put CurrentVsInitial and CurrentVsPrevious into one class?
//Too similar to displayResults?

public class CalculateCurrentVsPrevious
{
    public void CurrentVsPrevious(User currentUser)
    {
        double income = currentUser.getIncome() - currentUser.getPreviousWeek().getIncome();
        double expense = currentUser.getIncome() - currentUser.getPreviousWeek().getExpenses();
        double saveAmount = currentUser.getIncome() - currentUser.getPreviousWeek().getSaveAmount();
        double spendAmount = currentUser.getIncome() - currentUser.getPreviousWeek().getSpendAmount();

        double totalIncome = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getTotalIncome();
        double wageIncome = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getWageIncome();
        double otherIncome = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getOtherIncome();
        double rentExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getRentExpenses();
        double utilitiesExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getUtilitiesExpenses();
        double foodExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getFoodExpenses();
        double travelExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getTravelExpenses();
        double healthCareExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getHealthcareExpenses();
        double entertainmentExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getEntertainmentExpenses();
        double totalExpense = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getTotalExpenses();
        double netChange = currentUser.getBudget().getTotalIncome() - currentUser.getPreviousWeek().getBudget().getMonthlyNetChange();

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

    }
}
