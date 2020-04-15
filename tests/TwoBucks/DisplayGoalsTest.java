package TwoBucks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayGoalsTest {

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

    @Test
    void displayGoals() {
        DisplayGoals disp = new DisplayGoals();
        disp.displayGoals(user);

    }
}
