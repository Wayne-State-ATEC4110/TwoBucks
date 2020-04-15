import TwoBucks.Budget;
import TwoBucks.User;
import TwoBucks.Week;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class WeekTest {
    User user;

    @BeforeEach
    void setup(){
        user = new User("Bob","Marley", "bob@rasta.com", 1200, 120);
        user.setBudget(new Budget(10, 20, 30, 40, 50, 60,
                70,80,90,100,110));
        user.setSaveAmount(100);
        user.setSpendAmount(280);
        user.setInitialWeek(new Week(500, 200, 100,100,new Budget()));
        user.setPreviousWeek(new Week());
    }

    @Test
    void toNextWeek() {

        // Before toNextWeek
        // Test that previousWeek variables are at 0
        assertEquals(0,user.getPreviousWeek().getIncome()); //Income
        assertEquals(0,user.getPreviousWeek().getExpenses()); //Expenses
        assertEquals(0,user.getPreviousWeek().getSaveAmount()); //SaveAmount
        assertEquals(0,user.getPreviousWeek().getSpendAmount()); //SpendAmount
        assertEquals(0,user.getPreviousWeek().getBudget().getRentExpenses()); //Rent
        assertEquals(0,user.getPreviousWeek().getBudget().getUtilitiesExpenses()); //Utilities
        assertEquals(0,user.getPreviousWeek().getBudget().getFoodExpenses()); //Food
        assertEquals(0,user.getPreviousWeek().getBudget().getTravelExpenses()); //Travel
        assertEquals(0,user.getPreviousWeek().getBudget().getHealthcareExpenses()); //Health
        assertEquals(0,user.getPreviousWeek().getBudget().getEntertainmentExpenses()); //Entertainment
        assertEquals(0,user.getPreviousWeek().getBudget().getTotalExpenses()); //TotalExpenses
        assertEquals(0,user.getPreviousWeek().getBudget().getMonthlyNetChange()); //MonthlyNetChange


        // Test user inputs
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                 System.lineSeparator()  + System.lineSeparator() +"-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        //Use toNextWeek();
        user.getPreviousWeek().toNextWeek(user);

        // Test that previousWeek variable copied
        assertEquals(1200,user.getIncome()); //Income
        assertEquals(120,user.getExpenses()); //Expenses
        assertEquals(100,user.getSaveAmount()); //SaveAmount
        assertEquals(280,user.getSpendAmount()); //SpendAmount
        assertEquals(40,user.getPreviousWeek().getBudget().getRentExpenses()); //Rent
        assertEquals(50,user.getPreviousWeek().getBudget().getUtilitiesExpenses()); //Utilities
        assertEquals(60,user.getPreviousWeek().getBudget().getFoodExpenses()); //Food
        assertEquals(70,user.getPreviousWeek().getBudget().getTravelExpenses()); //Travel
        assertEquals(80,user.getPreviousWeek().getBudget().getHealthcareExpenses()); //Health
        assertEquals(90,user.getPreviousWeek().getBudget().getEntertainmentExpenses()); //Entertainment
        assertEquals(100,user.getPreviousWeek().getBudget().getTotalExpenses()); //TotalExpenses
        assertEquals(110,user.getPreviousWeek().getBudget().getMonthlyNetChange()); //MonthlyNetChange

        // Test that current budget variables are set to 0
        assertEquals(0,user.getBudget().getRentExpenses()); //Rent
        assertEquals(0,user.getBudget().getUtilitiesExpenses()); //Utilities
        assertEquals(0,user.getBudget().getFoodExpenses()); //Food
        assertEquals(0,user.getBudget().getTravelExpenses()); //Travel
        assertEquals(0,user.getBudget().getHealthcareExpenses()); //Health
        assertEquals(0,user.getBudget().getEntertainmentExpenses()); //Entertainment
        assertEquals(0,user.getBudget().getTotalExpenses()); //TotalExpenses
        assertEquals(0,user.getBudget().getMonthlyNetChange()); //MonthlyNetChange


    }


}
