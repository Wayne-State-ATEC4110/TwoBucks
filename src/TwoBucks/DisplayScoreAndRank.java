/**
 * <h1>DisplayScoreAndRank</h1>
 *
 * <p>
 *     The DisplayScoreAndRank class outputs the currentUser's score and rank.
 *
 *     This class implements the Singleton design pattern.
 * </p>
 *
 * @author Mike Shea
 * @version 1.1
 * @since 4/20/20
 */

package TwoBucks;

public class DisplayScoreAndRank {

    /**
     * Private static variable
     */
    private static DisplayScoreAndRank displayScoreAndRank;

    /**
     * Private constructor
     */
    private DisplayScoreAndRank(){
        DisplayScoreAndRank displayScoreAndRank = new DisplayScoreAndRank();
    }

    /**
     * Public static method - returns instance of this class
     * @return displayScoreAndRank
     */
    public static DisplayScoreAndRank getInstance(){
        return displayScoreAndRank;
    }

    /**
     * Outputs currentUser's score and rank
     * @param currentUser
     */
    public static void outputScoreAndRank(User currentUser){

        System.out.println("User Score: " + currentUser.getScore() + " points");
        System.out.println("User Rank: " + currentUser.getRank());
        System.out.println("");
    }

    public static String[] outputScoreAndRankString(User currentUser) {
        String testString[] = {"User Score: " + currentUser.getScore() + " points\n" + "User Rank: Financial Novice"};
        return testString;
    }
}
