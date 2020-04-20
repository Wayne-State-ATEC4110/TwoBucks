/**
 * <h1>User</h1>
 * The User class is used throughout the program primarily uses
 * a pipe and filter architectural style. The values in the user
 * class will be updated based on user input and how it flows through
 * other processes.
 *
 * <p>
 *
 *
 * @author  Alex Gonzalez
 * @version 1.5
 * @since   03-04-2020
 */

package TwoBucks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {
    private String firstName;
    private String lastName;
    private String email;
    protected double income;
    protected double expenses;
    protected double saveAmount;
    protected double spendAmount;
    //Budget
    protected Budget budget;

    //Score
    private double score;

    //Rank
    String rank;

    //Week Class
    protected Week previousWeek;
    protected Week initialWeek;

    protected Week week;

    // Initial Week Boolean
    private boolean firstWeek;


    /**
     * Constructor used when no parameters are passed
     * @param Nothing
     */
    public User(){
        this.firstName = " ";
        this.lastName = " ";
        this.email = " ";
        this.income = 0;
        this.expenses = 0;
        this.saveAmount = 0;
        this.spendAmount = 0;
        this.budget = new Budget();
        this.week = new Week();
        this.previousWeek = new Week();
        this.initialWeek = new Week();
        this.setScore(0.0);
        this.setRank("Financial Novice");
        this.setFirstWeek(true);
    }

    /**
     * Constructor used for CreateUser Profile
     * Constructs a user instance with 3 parameters
     * @param firstName
     * @param lastName
     * @param email
     */
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.initialWeek = new Week();
        this.previousWeek = new Week();
        this.firstWeek = true;
        this.score = 0;
        this.calculateRank();
    }


    /**
     * Constructor used to load saved
     * profile information.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param income
     * @param expenses
     */
    public User(String firstName, String lastName, String email, double income, double expenses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.income = income;
        this.expenses = expenses;
    }

    /**
     *
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param income
     * @param expenses
     * @param saveAmount
     * @param spendAmount
     * @param budget
     */
    public User(String firstName, String lastName, String email, double income, double expenses, double saveAmount,
                double spendAmount, Budget budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.income = income;
        this.expenses = expenses;
        this.saveAmount = saveAmount;
        this.spendAmount = spendAmount;
        this.budget = budget;
    }

    public User(String firstName, String lastName, String email, double income, double expenses, double saveAmount,
                double spendAmount, Budget budget, Week initialWeek, Week previousWeek, double score, boolean firstWeek) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.income = income;
        this.expenses = expenses;
        this.saveAmount = saveAmount;
        this.spendAmount = spendAmount;
        this.budget = budget;
        this.initialWeek = initialWeek;
        this.previousWeek = previousWeek;
        this.score = score;
        this.calculateRank();
        this.firstWeek = firstWeek;


    }

    /**
     * Get first name method
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get last name method
     *
     * @return lastName
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * Get email address method
     *
     * @return email
     */
    public String getEmail() {

        return email;
    }

    /**
     * Checks if email is in valid format
     *
     * @param email
     * @return
     */
    public boolean validEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if(this.email== null){
            return false;
        }

        return pattern.matcher(email).matches();

    }

    /**
     * Get income method
     *
     * @return income
     */
    public double getIncome() {

        return income;
    }

    /**
     * Get expenses method
     *
     * @return expenses
     */
    public double getExpenses() {

        return expenses;
    }

    /**
     * Get save amoung method
     *
     * @return saveAmount
     */
    public double getSaveAmount() {

        return saveAmount;
    }

    /**
     * Get spend amount method
     *
     * @return spendAmount
     */
    public double getSpendAmount() {
        return spendAmount;
    }

    /**
     * Set first name method
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * Set last anme method
     *
     * @param lastName
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /**
     * Set Email Method
     *
     * @param email
     */
    public void setEmail(String email) {

        this.email = email;
    }

    /**
     * Set Income method
     *
     * @param income
     */
    public void setIncome(double income) {

        this.income = income;
    }

    /**
     * Set expenses method
     *
     * @param expenses
     */
    public void setExpenses(double expenses) {

        this.expenses = expenses;
    }

    /**
     * Set save amount method
     *
     * @param saveAmount
     */
    public void setSaveAmount(double saveAmount) {
        this.saveAmount = saveAmount;
    }

    /**
     * Set spend amount method
     *
     * @param spendAmount
     */
    public void setSpendAmount(double spendAmount) {
        this.spendAmount = spendAmount;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public void calculateScore(){
        double scoreCalc = ((this.spendAmount - this.getBudget().getTotalExpenses()) +
                ((this.getIncome() - this.getBudget().getTotalExpenses()) - this.getSaveAmount()));
        scoreCalc += getScore();

        if(scoreCalc<0){
            this.setScore(0);
        }
        else{
            this.setScore(scoreCalc);
        }

    }

    /**
     * getScore method
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * setScore method
     * @param score
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Method calculates and sets the rank for the user
     * Method uses, getScore and bases their rank on their score
     * To protect the user from falling below 0, if the score is
     * negative, the score is reset to 0.
     */
    public void calculateRank(){
        if(this.getScore()<= 500){
            this.setRank("Financial Novice");
        }
        else if(500 < this.getScore() && this.getScore() <= 1500){
            this.setRank("Financial Rookie");
        }
        else if(1500 < this.getScore() && this.getScore() <= 4000){
            this.setRank("Intermediate Financier");
        }
        else if(4000 < this.getScore() && this.getScore() <= 8000){
            this.setRank("Master Financier");
        }
        else if(8000 < this.getScore() && this.getScore() <= 16000){
            this.setRank("Grand Master Financier");
        }
        else if(this.getScore() > 16000){
            this.setRank("Financial Guru");
        }

    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public boolean isFirstWeek() {
        return firstWeek;
    }

    public void setFirstWeek(boolean firstWeek) {
        this.firstWeek = firstWeek;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public Week getPreviousWeek() {
        return previousWeek;
    }

    public void setPreviousWeek(Week previousWeek) {
        this.previousWeek = previousWeek;
    }

    public Week getInitialWeek() {
        return initialWeek;
    }

    public void setInitialWeek(Week initialWeek) {
        this.initialWeek = initialWeek;
    }

    public void clearBudget(){
        this.budget.setWageIncome(0);
        this.budget.setOtherIncome(0);
        this.budget.setEntertainmentExpenses(0);
        this.budget.setFoodExpenses(0);
        this.budget.setHealthcareExpenses(0);
        this.budget.setRentExpenses(0);
        this.budget.setTravelExpenses(0);
        this.budget.setUtilitiesExpenses(0);
        this.budget.setTotalExpenses(0);
        this.budget.setMonthlyNetChange(0);
    }

    /**
     * Override to string method in order to save
     * and load user data.
     *
     * @return firstName, lastName, email, income, expenses
     */
    @Override
    public String toString() {
        return
                firstName +
                ", " + lastName +
                ", " + email +
                ", " + income +
                ", " + expenses +
                ", " + saveAmount +
                ", " + spendAmount +
                ", " + this.getBudget().toString()+
                 ", "+ this.getInitialWeek().toString()+
                ", "+ this.getPreviousWeek().toString()+
                ", "+ score +
                ", "+firstWeek
         ;
    }
}
