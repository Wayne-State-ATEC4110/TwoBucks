package TwoBucks;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReportToTextTest {

    @Test
    public void printInfoToFile() {

        User currentUser = new User();
        ReportToText RTT = new ReportToText();
        CreateReport CR = new CreateReport();

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

        RTT.printInfoToFile(currentUser); // file is created successfully with proper title and contents


    }
}