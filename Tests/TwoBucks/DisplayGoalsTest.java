package TwoBucks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayGoalsTest {

    @Test
    void displayGoals() {
        User user = new User("Bob","Marley", "bob@rasta.com", 1200, 120);
        user.setBudget(new Budget(10, 20, 30, 40, 50, 60, 70,80));
        user.setSaveAmount(100);
        user.setSpendAmount(280);
        DisplayGoals disp = new DisplayGoals();
        disp.displayGoals(user);

    }
}