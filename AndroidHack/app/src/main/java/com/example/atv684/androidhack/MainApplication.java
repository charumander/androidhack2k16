package com.example.atv684.androidhack;

import android.app.Application;

import com.example.atv684.androidhack.objects.HouseTypePref;
import com.example.atv684.androidhack.objects.User;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.example.atv684.androidhack.objects.House;

import java.util.List;


/**
 * Created by pyc393 on 8/27/16.
 */
public class MainApplication extends Application {
    private List<House> searchResults;

    private static MainApplication mainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
        mainApplication = this;
    }

    /**
     * Get the Application object
     *
     * @return the Application
     */
    public static MainApplication getApplication() {
        return mainApplication;
    }

    public List<House> getSearchResults() {
        return searchResults;
    }

    public User getUser(){
        User user = new User();

        user.setCreditScore(650);
        user.setYearlyIncome(50000);
        user.setDesiredDistance(100);
        user.setMonthlyExpenses(600);
        user.setPreference(HouseTypePref.FamilyHome.toString());

        return user;
    }

    public void setSearchResults(List<House> searchResults) {
        this.searchResults = searchResults;
    }
}
