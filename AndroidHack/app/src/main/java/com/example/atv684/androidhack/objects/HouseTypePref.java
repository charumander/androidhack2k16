package com.example.atv684.androidhack.objects;

/**
 * Created by atv684 on 8/27/16.
 */
public enum HouseTypePref{
    Apartment("apartment"),
    TownHouse("town house"),
    FamilyHome("family home");

    private final String type;


    private HouseTypePref(final String text) {
        this.type = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return type;
    }
}