package TwoBucks;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    @Test public void TestDefaultConstructor(){
        Budget b = new Budget();
        assert(b.getWageIncome() == 0.0);
        assert(b.getOtherIncome() == 0.0);
        assert(b.getTotalIncome() == 0.0);
        assert(b.getRentExpenses() == 0.0);
        assert(b.getUtilitiesExpenses() == 0.0);
        assert(b.getFoodExpenses() == 0.0);
        assert(b.getTravelExpenses() == 0.0);
        assert(b.getHealthcareExpenses() == 0.0);
        assert(b.getEntertainmentExpenses() == 0.0);
        assert(b.getTotalExpenses() == 0.0);
        assert(b.getMonthlyNetChange() == 0.0);
    }


    @Test public void TestArgConstructor(){
        Budget b = new Budget(1000.00, 500.00, 100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0);
        assert(b.getWageIncome() == 1000.0);
        assert(b.getOtherIncome() == 500.0);
        assert(b.getTotalIncome() == 100.0);
        assert(b.getRentExpenses() == 200.0);
        assert(b.getUtilitiesExpenses() == 300.0);
        assert(b.getFoodExpenses() == 400.0);
        assert(b.getTravelExpenses() == 500.0);
        assert(b.getHealthcareExpenses() == 600.0);
        assert(b.getEntertainmentExpenses() == 700.0);
        assert(b.getTotalExpenses() == 800.0);
        assert(b.getMonthlyNetChange() == b.getTotalIncome() - b.getTotalExpenses());
    }

    @Test public void TestCalculateTotalIncome(){
        Budget b = new Budget();
        b.setWageIncome(1000.00);
        b.setOtherIncome(500.00);
        b.CalculateTotalIncome();

        assert(b.getTotalIncome() == 1500.00);
    }

    @Test public void TestCalculateTotalExpenses(){
        Budget b = new Budget();
        b.setRentExpenses(100.00);
        b.setUtilitiesExpenses(100.00);
        b.setFoodExpenses(100.00);
        b.setTravelExpenses(100.00);
        b.setHealthcareExpenses(100.00);
        b.setEntertainmentExpenses(100.00);
        b.CalculateTotalExpenses();
        assert(b.getTotalExpenses() == 600.00);
    }

    @Test public void TestCalculateMonthlyNetChange(){
        Budget b = new Budget();
        b.setTotalIncome(1000.00);
        b.setTotalExpenses(500.00);
        b.CalculateMonthlyNetChange();
        assert(b.getMonthlyNetChange() == 500.00);
    }


    @Test
    void receiveWageIncome() {
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() +"-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        Budget testClass = new Budget();
        testClass.ReceiveWageIncome();
        assert(testClass.getWageIncome() == 1.0);
    }

    @Test
    void receiveOtherIncome() {
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() +"-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        Budget testClass = new Budget();
        testClass.ReceiveOtherIncome();
        assert(testClass.getOtherIncome() == 1.0);
    }

    @Test
    void receiveRentExpenses() {
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() +"-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        Budget testClass = new Budget();
        testClass.ReceiveRentExpenses();
        assert(testClass.getRentExpenses() == 1.0);
    }

    @Test
    void receiveUtilitiesExpenses() {
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() +"-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        Budget testClass = new Budget();
        testClass.ReceiveUtilitiesExpenses();
        assert(testClass.getUtilitiesExpenses() == 1.0);
    }

    @Test
    void receiveFoodExpenses() {

    }

    @Test
    void receiveTravelExpenses() {
    }

    @Test
    void receiveHealthcareExpenses() {
    }

    @Test
    void receiveEntertainmentExpenses() {
    }

    @Test
    void receiveUserSelection() {
    }