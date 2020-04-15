package TwoBucks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcScore_CalcRank {

    User user;

    /**
     * Sets up user class for testing each method
     */
    @BeforeEach
    void setup(){
        user = new User("Bob","Marley", "bob@rasta.com", 1200, 120);
        user.setBudget(new Budget(10, 20, 30, 40, 50, 60,
                70,80,90,100,110));
        user.setSaveAmount(100);
        user.setSpendAmount(280);
        user.setInitialWeek(new Week(500, 200, 100,100,new Budget()));
        user.setPreviousWeek(new Week(500, 200, 100,100,new Budget()));
    }


    /**
     * Test calculateScore method
     */
    @Test
    void calculateScore() {
        // Case where score is positive
        user.calculateScore();
        assertEquals(1180.0,user.getScore());

        // Case where user score is calculated after previous week
        user.calculateScore();
        assertEquals(2360, user.getScore());

        // Case where score subtracts from user's current score
        user.setIncome(0);
        user.setSpendAmount(0);
        user.calculateScore();
        assertEquals(2060, user.getScore());

        // Case where score is negative (should reset score to 0)
        user.setScore(0);
        user.calculateScore();
        assertEquals(0.0, user.getScore());

    }

    /**
     * Tests calculateRank method
     */
    @Test
    void calculateRank() {
        //Financial Novice Case
        user.setScore(0);
        user.calculateRank();
        assertSame("Financial Novice", user.getRank());

        //Financial Novice Case at Boundary
        user.setScore(500);
        user.calculateRank();
        assertSame("Financial Novice", user.getRank());

        //Financial Rookie Case
        user.setScore(501);
        user.calculateRank();
        assertSame("Financial Rookie", user.getRank());

        //Financial Rookie Case at Boundary
        user.setScore(1500);
        user.calculateRank();
        assertSame("Financial Rookie", user.getRank());

        //Financial Rookie Case
        user.setScore(1501);
        user.calculateRank();
        assertSame("Intermediate Financier", user.getRank());

        //Financial Rookie Case at Boundary
        user.setScore(4000);
        user.calculateRank();
        assertSame("Intermediate Financier", user.getRank());

        //Master Financier Case
        user.setScore(4001);
        user.calculateRank();
        assertSame("Master Financier", user.getRank());

        //Master Financier Case at Boundary
        user.setScore(8000);
        user.calculateRank();
        assertSame("Master Financier", user.getRank());

        //Grand Master Financier Case
        user.setScore(8001);
        user.calculateRank();
        assertSame("Grand Master Financier", user.getRank());

        //Grand Master Financier Case at Boundary
        user.setScore(16000);
        user.calculateRank();
        assertSame("Grand Master Financier", user.getRank());

        //Financial Guru Case
        user.setScore(16001);
        user.calculateRank();
        assertSame("Financial Guru", user.getRank());


    }
}