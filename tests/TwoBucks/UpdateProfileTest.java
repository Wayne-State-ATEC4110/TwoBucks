import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class UpdateProfileTest {

    @Test
    public void updateFirstName()throws IOException { // User must choose option 1 to test
        UpdateProfile uP = new UpdateProfile();
        User User1 = new User();
        User User2 = new User();
        User1.setFirstName("Frino");
        User1.setLastName("Jais");
        User1.setEmail("el6583@wayne.edu");
        User2.setFirstName("Bob");
        User2.setLastName("Marley");
        User2.setEmail("bobmarley@gmail.com");
        assertFalse(User2 == User1); // testing if the variable currently in user 1 can be changed to user 2

    }
    @Test
    public void updateLastName()throws IOException{ // User must choose option 2 to test
        UpdateProfile uP = new UpdateProfile();
        User User1 = new User();
        User User2 = new User();
        User1.setFirstName("Frino");
        User1.setLastName("Jais");
        User1.setEmail("el6583@wayne.edu");
        User2.setFirstName("Bob");
        User2.setLastName("Marley");
        User2.setEmail("bobmarley@gmail.com");
        assertFalse(User2== User1); // testing if the variable currently in user 1 can be changed to user 2
    }
    @Test
    public void updateEmail()throws IOException{ // User must choose option 2 to test
        UpdateProfile uP = new UpdateProfile();
        User User1 = new User();
        User User2 = new User();
        User1.setFirstName("Frino");
        User1.setLastName("Jais");
        User1.setEmail("el6583@wayne.edu");
        User2.setFirstName("Frino");
        User2.setLastName("Jais");
        User2.setEmail("bobmarley@gmail.com");
        assertFalse(User2==User1); // testing if the variable currently in user 1 can be changed to user 2
    }
}