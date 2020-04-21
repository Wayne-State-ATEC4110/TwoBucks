// Unit Test for US10. CalculateGoalsVsPerformance
// By Frino Jais

package TwoBucks;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculateGoalsVsPerformanceTest {

    @Test
    public void performanceAnalysis() {
        CalculateGoalsVsPerformance cGvP = new CalculateGoalsVsPerformance();
        User User1 = new User();
        User1.setIncome(2000);
        User1.setSpendAmount(300);
        User1.setSaveAmount(400);
        User1.setExpenses(500);
        cGvP.PerformanceAnalysis(User1); // running the test with the values associated with the created object
                                         // the correct results and output is given *TEST PASSED*
                                         // no use of assert because method is void
    }


}