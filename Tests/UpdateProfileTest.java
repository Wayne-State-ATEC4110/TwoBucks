import org.junit.Test;

import static org.junit.Assert.*;

public class UpdateProfileTest {

    @Test
    public void updateFirstName() { // User must choose option 1 to test
        UpdateProfile uP = new UpdateProfile();
        User User1 = new User();
        User User2 = new User();
        User1.setFirstName("Frino");
        User1.setLastName("Jais");
        User1.setEmail("el6583@wayne.edu");
        User2.setFirstName("Bob");
        User2.setLastName("Marley");
        User2.setEmail("bobmarley@gmail.com");
        uP.updateInfo(User1); // choose 1 and enter "Bob"
        assertEquals(User2,User1); // testing if the variable currently in user 1 can be changed to user 2

    }

    public void updateLastName(){ // User must choose option 2 to test
        UpdateProfile uP = new UpdateProfile();
        User User1 = new User();
        User User2 = new User();
        User1.setFirstName("Frino");
        User1.setLastName("Jais");
        User1.setEmail("el6583@wayne.edu");
        User2.setFirstName("Bob");
        User2.setLastName("Marley");
        User2.setEmail("bobmarley@gmail.com");
        uP.updateInfo(User1); // choose 2 and enter "Marley"
        assertEquals(User2,User1); // testing if the variable currently in user 1 can be changed to user 2
    }

    public void updateEmail(){ // User must choose option 2 to test
        UpdateProfile uP = new UpdateProfile();
        User User1 = new User();
        User User2 = new User();
        User1.setFirstName("Frino");
        User1.setLastName("Jais");
        User1.setEmail("el6583@wayne.edu");
        User2.setFirstName("Bob");
        User2.setLastName("Marley");
        User2.setEmail("bobmarley@gmail.com");
        uP.updateInfo(User1); // choose 3 and enter bobmarley@gmail.com
        assertEquals(User2,User1); // testing if the variable currently in user 1 can be changed to user 2
    }
}