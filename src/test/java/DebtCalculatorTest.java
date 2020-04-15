import TwoBucks.DebtCalculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DebtCalculatorTest {

    @Test
    public void TestReceiveDebtPrincipal() {
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() + "-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        DebtCalculator testClass = new DebtCalculator();
        testClass.ReceiveDebtPrincipal();
        assert(testClass.getDebtPrincipal() == 1.0);
    }

    @Test
    public void TestReceiveDebtInterestRate(){
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() + "-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        DebtCalculator testClass = new DebtCalculator();
        testClass.ReceiveDebtInterestRate();
        assert(testClass.getDebtInterestRate() == 1.0);
    }

    @Test
    public void receiveMonthlyPaymentAmount(){
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() + "-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        DebtCalculator testClass = new DebtCalculator();
        testClass.ReceiveMonthlyPaymentAmount();
        assert(testClass.getDebtMonthlyPayment() == 1.0);
    }

    @Test
    public void calculateDebtInterestAmount(){
        DebtCalculator testClass = new DebtCalculator();
        testClass.setMonthlyInterestRate(100);
        testClass.setDebtPrincipal(10);
        testClass.CalculateDebtInterestAmount();
        assert(testClass.getDebtInterestAmount() == 10);
    }

    @Test
    public void remainingMonths(){
        DebtCalculator testClass = new DebtCalculator();
        testClass.setDebtPrincipal(1000.00);
        testClass.setDebtInterestRate(12.00);
        testClass.setDebtMonthlyPayment(100.00);
        testClass.CalculateRemainingMonths();
        assert(testClass.getMonthsRemaining() == 11);
    }

    @Test
    public void userSelection(){
        // Create input stream to simulate user input until accepted value
        // (tests String, char, negative number, positive double)
        ByteArrayInputStream simulatedInput = new ByteArrayInputStream((
                "Hello" + System.lineSeparator() + 'a' + System.lineSeparator() + "-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(simulatedInput);

        DebtCalculator testClass = new DebtCalculator();
        testClass.ReceiveUserSelection();
        assert(testClass.getUserSelection() == 1);
    }


}