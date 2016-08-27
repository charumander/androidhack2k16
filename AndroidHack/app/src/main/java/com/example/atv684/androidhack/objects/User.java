package com.example.atv684.androidhack.objects;

/**
 * Created by atv684 on 8/27/16.
 */
public class User {

    int creditScore, targetPrice, monthlyExpenses, yearlyIncome, desiredDistance;

    String username, preference, zip;

    public User(String username, String zip, int targetPrice, int creditScore, int yearlyIncome){
        this.creditScore = creditScore;
        this.username = username;
        this.targetPrice = targetPrice;
        this.zip = zip;
        this.yearlyIncome = yearlyIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(int monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public int getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(int yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDesiredDistance() {
        return desiredDistance;
    }

    public void setDesiredDistance(int desiredDistance) {
        this.desiredDistance = desiredDistance;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
