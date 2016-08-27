package com.example.atv684.androidhack;

import com.example.atv684.androidhack.objects.House;

import java.util.ArrayList;

/**
 * Created by atv684 on 8/27/16.
 */
public class HouseUtil {

    public House getHouseByName(String name, ArrayList<House> houses){
        for(House house : houses){
            if(house.getName().equals(name)){
                return house;
            }
        }
        return null;
    }
}
