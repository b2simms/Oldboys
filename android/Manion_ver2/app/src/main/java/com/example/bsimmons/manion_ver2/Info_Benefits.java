package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */
public class Info_Benefits {

    private String name;
    private String carrier;
    private String policyNum;
    private String date;
    private String coverage;

    public Info_Benefits(String name, String carrier, String policyNum, String date, String coverage) {
        this.name = name;
        this.carrier = carrier;
        this.policyNum = policyNum;
        this.date = date;
        this.coverage = coverage;
    }

    public String getName() {
        return name;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getPolicyNum() {
        return policyNum;
    }

    public String getDate() {
        return date;
    }

    public String getCoverage() {
        return coverage;
    }
}