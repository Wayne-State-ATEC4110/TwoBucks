package TwoBucks;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;


public class CreateReportTest {

    @Test
    public void reportContents() {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        User currentUser = new User();
        currentUser.setFirstName("Frino");
        currentUser.setLastName("Jais");
        currentUser.setEmail("frinojais@gmail.com");
        currentUser.setSpendAmount(500);
        currentUser.setExpenses(450);
        currentUser.setIncome(2000);
        currentUser.setSaveAmount(600);
        Budget budget = new Budget();
        currentUser.setBudget(budget);
        budget.setRentExpenses(120);
        budget.setUtilitiesExpenses(60);
        budget.setFoodExpenses(50);
        budget.setTravelExpenses(50);
        budget.setHealthcareExpenses(70);
        budget.setEntertainmentExpenses(10);

        CreateReport CR = new CreateReport();

        String testString[] = {"******** TwoBucks User Profile Data Report *********", " ",(dateFormatter.format(now))," ","Name: Frino Jais", "Email: frinojais@gmail.com", "Weekly Income: 2000.0", "Spending goal for this week: 500.0", "Your expenses this week: 450.0", "Your savings goal this week: 600.0","Your savings this week: 1550.0", "Budget for this week: ", "    - Rent: 120.0","    - Utilities: 60.0","    - Food: 50.0","    - Travel: 50.0","    - Healthcare: 70.0","    - Entertainment: 10.0"};
        assert(testString.equals(CR.reportContents(currentUser))); // check if the test array is equal to the actual array outputted by the test
    }

    @Test
    public void showReport() {

        CreateReport CR = new CreateReport();

        User currentUser = new User();
        currentUser.setFirstName("Frino");
        currentUser.setLastName("Jais");
        currentUser.setEmail("frinojais@gmail.com");
        currentUser.setSpendAmount(500);
        currentUser.setExpenses(450);
        currentUser.setIncome(2000);
        currentUser.setSaveAmount(600);
        Budget budget = new Budget();
        currentUser.setBudget(budget);
        budget.setRentExpenses(120);
        budget.setUtilitiesExpenses(60);
        budget.setFoodExpenses(50);
        budget.setTravelExpenses(50);
        budget.setHealthcareExpenses(70);
        budget.setEntertainmentExpenses(10);

        CR.showReport(currentUser); // report is shown in proper format in the test window with the assigned values
    }
}