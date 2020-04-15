package TwoBucks;

public class DisplayScoreAndRank {

    public void outputScoreAndRank(User currentUser){

        System.out.println("User Score: " + currentUser.getScore() + " points");
        System.out.println("User Rank: " + currentUser.getRank());
        System.out.println("");
    }
}
