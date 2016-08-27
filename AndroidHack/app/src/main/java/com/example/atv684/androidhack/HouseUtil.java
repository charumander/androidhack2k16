package com.example.atv684.androidhack;

import com.example.atv684.androidhack.objects.House;
import com.example.atv684.androidhack.objects.User;

import java.util.ArrayList;

/**
 * Created by atv684 on 8/27/16.
 */
public class HouseUtil {

    public static House getHouseByName(String name, ArrayList<House> houses){
        for(House house : houses){
            if(house.getName().equals(name)){
                return house;
            }
        }
        return null;
    }

    public static boolean canAffordHouse(House house){

        User user = MainApplication.getApplication().getUser();

        long housePrice = house.getCost();

        if(user.getYearlyIncome()/3 < housePrice/15/12){
            return false;
        }

        if(HouseUtil.isCreditTooLow(house)){
            return false;
        }

        return true;
    }


    public static boolean isCreditTooLow(House house) {
        User user = MainApplication.getApplication().getUser();

        return user.getCreditScore() < 600;
    }
}
