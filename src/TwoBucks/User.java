package TwoBucks;

public class User {
    private String firstName;
    private String lastName;
    //private String password;      //may use in future sprint
    private String email;
    private double income;
    private double expenses;
    //Budget


    public User(String firstName, String lastName, String email, double income, double expenses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.income = income;
        this.expenses = expenses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
}
