package com.example.bsimmons.databasetesting;

/**
 * Created by bsimmons on 18/08/2015.
 */
public class Team {

    public Team(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    private String name;
    private String city;


}
