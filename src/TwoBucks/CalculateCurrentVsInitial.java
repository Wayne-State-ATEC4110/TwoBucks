/**
 * <h>CalculateCurrentVsInitial</h>
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

public class CalculateCurrentVsInitial
{
    public void CurrentVsInitial(User currentUser)
    {
        double income = currentUser.getIncome() - currentUser.getInitialWeek().getIncome();
        double expense = currentUser.getIncome() - currentUser.getInitialWeek().getExpenses();
        double saveAmount = currentUser.getIncome() - currentUser.getInitialWeek().getSaveAmount();
        double spendAmount = currentUser.getIncome() - currentUser.getInitialWeek().getSpendAmount();

        double totalIncome = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getTotalIncome();
        double wageIncome = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getWageIncome();
        double otherIncome = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getOtherIncome();
        double rentExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getRentExpenses();
        double utilitiesExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getUtilitiesExpenses();
        double foodExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getFoodExpenses();
        double travelExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getTravelExpenses();
        double healthCareExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getHealthcareExpenses();
        double entertainmentExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getEntertainmentExpenses();
        double totalExpense = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getTotalExpenses();
        double netChange = currentUser.getBudget().getTotalIncome() - currentUser.getInitialWeek().getBudget().getMonthlyNetChange();

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

    }
}
