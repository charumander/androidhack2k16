package com.example.atv684.androidhack;

import android.app.Application;

import com.example.atv684.androidhack.objects.HouseTypePref;
import com.example.atv684.androidhack.objects.User;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.example.atv684.androidhack.objects.House;

import java.util.HashMap;
import java.util.List;


/**
 * Created by pyc393 on 8/27/16.
 */
public class MainApplication extends Application {
    private List<House> searchResults;

    public HashMap<String, Boolean> houseStatuses;

    public HashMap<String, House> swipedHouses;

    private static MainApplication mainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
        mainApplication = this;

        houseStatuses = new HashMap<String, Boolean>();
        swipedHouses = new HashMap<String, House>();
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

    /**
     * set to true if accepted, false if rejected
     * @param name
     * @param status
     */
    public void setHouseStatus(String name, Boolean status){
        houseStatuses.put(name, status);
    }

    public Boolean getHouseStatus(String name) {
        return houseStatuses.get(name);
    }

    public void addSwipedHouse(String name, House house){
        swipedHouses.put(name, house);
    }

    public House getSwipedHouse(String name){
        return swipedHouses.get(name);
    }
}
