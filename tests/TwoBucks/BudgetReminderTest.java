package TwoBucks;

import org.junit.Test;

import static org.junit.Assert.*;

public class BudgetReminderTest {


    @Test
    public void budgetAddReminder() {
        BudgetReminder budgetReminder = new BudgetReminder();
        Budget budget = new Budget();
        assert(budget.getWageIncome() == 100.0);
        assert(budget.getOtherIncome() == 100.0);
        assert(budget.getTotalIncome() == 100.0);
        assert(budget.getRentExpenses() == 100.0);
        assert(budget.getUtilitiesExpenses() == 100.0);
        assert(budget.getFoodExpenses() == 100.0);
        assert(budget.getTravelExpenses() == 100.0);
        assert(budget.getHealthcareExpenses() == 100.0);
        assert(budget.getEntertainmentExpenses() == 100.0);
        assert(budget.getTotalExpenses() == 100.0);
        assert(budget.getMonthlyNetChange() == 100.0);
        budgetReminder.BudgetAddReminder(amount);
    }
    @Test
    public void budgetRemoveReminder()
    {
        BudgetReminder budgetReminder = new BudgetReminder();
        Budget budget = new Budget();
        assert(budget.getWageIncome() == 100.0);
        assert(budget.getOtherIncome() == 100.0);
        assert(budget.getTotalIncome() == 100.0);
        assert(budget.getRentExpenses() == 100.0);
        assert(budget.getUtilitiesExpenses() == 100.0);
        assert(budget.getFoodExpenses() == 100.0);
        assert(budget.getTravelExpenses() == 100.0);
        assert(budget.getHealthcareExpenses() == 100.0);
        assert(budget.getEntertainmentExpenses() == 100.0);
        assert(budget.getTotalExpenses() == 100.0);
        assert(budget.getMonthlyNetChange() == 100.0);
        budgetReminder.BudgetRemoveReminder(amount);
    }


}