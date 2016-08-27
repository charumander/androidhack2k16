package com.example.atv684.androidhack.objects;

import java.util.List;

/**
 * Created by atv684 on 8/27/16.
 */
public class House {

    String name, description,zip, city , type;

    long beds, baths;

    private List<String> houseImages;

    long cost;

    public House(){

    }

    public House(String name, String description, String zip, int cost, List<String> houseImages, int beds, int baths, String type){
        this.name = name;
        this.description = description;
        this.zip = zip;
        this.cost = cost;
        this.houseImages = houseImages;
        this.beds = beds;
        this.baths = baths;
        this.type = type;
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

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public List<String> getHouseImages() {
        return houseImages;
    }

    public void setHouseImages(List<String> houseImages) {
        this.houseImages = houseImages;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBeds() {
        return beds;
    }

    public void setBeds(long beds) {
        this.beds = beds;
    }

    public long getBaths() {
        return baths;
    }

    public void setBaths(long baths) {
        this.baths = baths;
    }
}
