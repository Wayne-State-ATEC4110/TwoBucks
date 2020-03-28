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

/*
    @Test public void TestArgConstructor(){
        Budget b = new Budget(1000.00, 500.00, 100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0);
        assert(b.getWageIncome() == 1000.0);
        assert(b.getOtherIncome() == 500.0);
        //assert(b.getTotalIncome() == 100.00);
        assert(b.getRentExpenses() == 200.0);
        assert(b.getUtilitiesExpenses() == 300.0);
        assert(b.getFoodExpenses() == 400.0);
        assert(b.getTravelExpenses() == 500.0);
        //assert(b.getHealthcareExpenses() == 600.0);
        //assert(b.getEntertainmentExpenses() == 700.0);
        //assert(b.getTotalExpenses() == 800.0);
        assert(b.getMonthlyNetChange() == b.getTotalIncome() - b.getTotalExpenses());
    }


    @Test public void TestToString(){

    }








    @Test public void TestReceiveWageIncome(){

    }


*/

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

        assert(b.getTotalExpenses() == 600.00);
    }

    @Test public void TestCalculateMonthlyNetChange(){
        Budget b = new Budget();
        b.setTotalIncome(1000.00);
        b.setTotalExpenses(500.00);
        b.
        assert(b.getMonthlyNetChange() == 500);
    }
}