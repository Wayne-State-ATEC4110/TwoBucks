// Unit Test for CalculateCurrentVsInitial
// By Sawyer Kisha

package TwoBucks;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateCurrentVsInitialTest
{

    @Test
    public void currentVsInitial()
    {
        CalculateCurrentVsInitial calculateCurrentVsInitial = new CalculateCurrentVsInitial();
        User user = new User();
        user.setIncome(2000);
        user.setSpendAmount(300);
        user.setSaveAmount(400);
        user.setExpenses(500);

        user.getBudget().setTotalIncome(2000);
        user.getBudget().setWageIncome(1000);
        user.getBudget().setOtherIncome(300);
        user.getBudget().setRentExpenses(300);
        user.getBudget().setUtilitiesExpenses(200);
        user.getBudget().setFoodExpenses(200);
        user.getBudget().setTravelExpenses(100);
        user.getBudget().setHealthcareExpenses(100);
        user.getBudget().setEntertainmentExpenses(50);
        user.getBudget().setTotalExpenses(800);
        user.getBudget().setMonthlyNetChange(300);
        calculateCurrentVsInitial.CurrentVsInitial(user);

        //Calculating difference
        double income = user.getIncome() - user.getInitialWeek().getIncome();
        double expense = user.getExpenses() - user.getInitialWeek().getExpenses();
        double saveAmount = user.getSaveAmount() - user.getInitialWeek().getSaveAmount();
        double spendAmount = user.getSpendAmount() - user.getInitialWeek().getSpendAmount();

        double totalIncome = user.getBudget().getTotalIncome() - user.getInitialWeek().getBudget().getTotalIncome();
        double wageIncome = user.getBudget().getWageIncome() - user.getInitialWeek().getBudget().getWageIncome();
        double otherIncome = user.getBudget().getOtherIncome() - user.getInitialWeek().getBudget().getOtherIncome();
        double rentExpense = user.getBudget().getRentExpenses() - user.getInitialWeek().getBudget().getRentExpenses();
        double utilitiesExpense = user.getBudget().getUtilitiesExpenses() - user.getInitialWeek().getBudget().getUtilitiesExpenses();
        double foodExpense = user.getBudget().getFoodExpenses() - user.getInitialWeek().getBudget().getFoodExpenses();
        double travelExpense = user.getBudget().getTravelExpenses() - user.getInitialWeek().getBudget().getTravelExpenses();
        double healthCareExpense = user.getBudget().getHealthcareExpenses() - user.getInitialWeek().getBudget().getHealthcareExpenses();
        double entertainmentExpense = user.getBudget().getEntertainmentExpenses() - user.getInitialWeek().getBudget().getEntertainmentExpenses();
        double totalExpense = user.getBudget().getTotalExpenses() - user.getInitialWeek().getBudget().getTotalExpenses();
        double netChange = user.getBudget().getMonthlyNetChange() - user.getInitialWeek().getBudget().getMonthlyNetChange();

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
    }
}

