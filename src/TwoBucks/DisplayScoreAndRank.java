/**
 * <h1>DisplayScoreAndRank</h1>
 *
 * <p>
 *     The DisplayScoreAndRank class outputs the currentUser's score and rank
 * </p>
 *
 * @author Mike Shea
 * @version 1.1
 * @since 4/20/20
 */

package TwoBucks;

public class DisplayScoreAndRank {

    /**
     * Outputs currentUser's score and rank
     * @param currentUser
     */
    public void outputScoreAndRank(User currentUser){

        System.out.println("User Score: " + currentUser.getScore() + " points");
        System.out.println("User Rank: " + currentUser.getRank());
        System.out.println("");
    }
}
