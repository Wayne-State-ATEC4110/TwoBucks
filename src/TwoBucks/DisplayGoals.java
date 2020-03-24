package TwoBucks;

public class DisplayGoals {

    public void displayGoals(User user){
        System.out.println("======== Current Goals ========");
        System.out.println("Weekly saving goal: " + user.getSaveAmount());
        System.out.println("Weekly spending goal: " + user.getSpendAmount());

    }
}
