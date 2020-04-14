package TwoBucks;

public class DisplayResults {

    public void outputResults(User currentUser){

        System.out.println("Initial Week");
        System.out.println("===================");
        currentUser.getInitialWeek().getBudget().DisplayBudget();
        System.out.println("");
        CalculateCurrentVsInitial calculateCurrentVsInitial = new CalculateCurrentVsInitial();
        calculateCurrentVsInitial.CurrentVsInitial(currentUser);
        System.out.println("");

        System.out.println("Previous Week");
        System.out.println("===================");
        currentUser.getPreviousWeek().getBudget().DisplayBudget();
        System.out.println("");
        CalculateCurrentVsPrevious calculateCurrentVsPrevious = new CalculateCurrentVsPrevious();
        calculateCurrentVsPrevious.CurrentVsPrevious(currentUser);
        System.out.println("");

        System.out.println("Current Week");
        System.out.println("===================");
        currentUser.getBudget().DisplayBudget();
    }
}