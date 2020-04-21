package TwoBucks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayResultsTest {

    @Test
    public void DisplayResultsTest(){
        // Initialize User object
        User currentUser = new User();

        // Initial Week
        Week initialWeek = new Week();
        Budget initialBudget = new Budget();
        initialBudget.setWageIncome(100.00);
        initialBudget.setOtherIncome(100.00);
        initialBudget.setRentExpenses(100.00);
        initialBudget.setFoodExpenses(100.00);
        initialBudget.setUtilitiesExpenses(100.00);
        initialBudget.setEntertainmentExpenses(100.00);
        initialBudget.setTravelExpenses(100.00);
        initialWeek.setBudget(initialBudget);
        currentUser.setInitialWeek(initialWeek);

        // Previous Week
        Week previousWeek = new Week();
        Budget previousBudget = new Budget();
        currentUser.setPreviousWeek(initialWeek);
        previousBudget.setWageIncome(100.00);
        previousBudget.setOtherIncome(100.00);
        previousBudget.setRentExpenses(100.00);
        previousBudget.setFoodExpenses(100.00);
        previousBudget.setUtilitiesExpenses(100.00);
        previousBudget.setEntertainmentExpenses(100.00);
        previousBudget.setTravelExpenses(100.00);
        previousWeek.setBudget(initialBudget);
        currentUser.setPreviousWeek(previousWeek);

        // Current Budget
        Budget currentBudget = new Budget();
        currentBudget.setWageIncome(100.00);
        currentBudget.setOtherIncome(100.00);
        currentBudget.setRentExpenses(100.00);
        currentBudget.setFoodExpenses(100.00);
        currentBudget.setUtilitiesExpenses(100.00);
        currentBudget.setEntertainmentExpenses(100.00);
        currentBudget.setTravelExpenses(100.00);
        currentUser.setBudget(currentBudget);

        String[] methodString = DisplayResults.outputResultsString(currentUser);
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


        assertArrayEquals(testString, methodString);
    }

}