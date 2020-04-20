package TwoBucks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendEmailTest {

    User user;

    @BeforeEach
    void setup(){
            user = new User("Bob","Marley", "bob@domain.com", 1200, 120);
            user.setBudget(new Budget(10, 20, 30, 40, 50, 60,
                    70,80,90,100,110));
            user.setSaveAmount(100);
            user.setSpendAmount(280);
            user.setInitialWeek(new Week(500, 200, 100,100,new Budget()));
            user.setPreviousWeek(new Week());
    }


    @Test
    void sendEmail() {
        SendEmail send = new SendEmail();
        send.sendEmail(user);

    }
}