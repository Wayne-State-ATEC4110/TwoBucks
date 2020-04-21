package TwoBucks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayScoreAndRankTest {

    @Test
    public void testDisplay(){
        // Initialize
        User currentUser = new User();
        DisplayScoreAndRank display = DisplayScoreAndRank.getInstance();
        currentUser.setRank("Financial Novice");
        currentUser.setScore(100);

        // Display User Score and Rank
        DisplayScoreAndRank.outputScoreAndRank(currentUser);

        String testString[] = {"User Score: 100.0 points\n" + "User Rank: Financial Novice"};
        String[] methodString= (DisplayScoreAndRank.outputScoreAndRankString(currentUser));

        assertArrayEquals(testString, methodString);
    }
}