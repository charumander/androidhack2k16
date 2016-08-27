package com.example.atv684.androidhack.objects;

/**
 * Created by atv684 on 8/27/16.
 */
public class House {

    String name, description,zip;

    int cost;

    public House(){

    }

    public House(String name, String description, String zip, int cost){
        this.name = name;
        this.description = description;
        this.zip = zip;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
