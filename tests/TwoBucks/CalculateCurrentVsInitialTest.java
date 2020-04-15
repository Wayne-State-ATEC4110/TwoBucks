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
    }
}

