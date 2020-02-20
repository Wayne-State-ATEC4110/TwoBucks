package TwoBucks;

// Two Bucks
// By Sawyer Kisha

public class Main
{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        EnterWeeklyExpense enterWeeklyExpense = new EnterWeeklyExpense();

        while (menu.getOption() != 5) {
            menu.showOptions();
            menu.selectOption();

            if (menu.getOption() == 2) {
                enterWeeklyExpense.setUserExpenses();
            }
        }
    }
}
