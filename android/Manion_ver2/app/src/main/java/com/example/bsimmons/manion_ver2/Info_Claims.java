package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 21/07/2015.
 */
public class Info_Claims {

    public Info_Claims(String claimant, String date, String code, String paid, String received, String payInfo) {
        this.claimant = claimant;
        this.date = date;
        this.code = code;
        this.paid = paid;
        this.received = received;
        this.payInfo = payInfo;
    }
    public Info_Claims(){
    }

    public String getPayInfo() {
        return payInfo;
    }

    public String getClaimant() {
        return claimant;
    }

    public String getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public String getPaid() {
        return paid;
    }

    public String getReceived() {
        return received;
    }

    private String claimant;
    private String date;
    private String code;
    private String paid;
    private String received;
    private String payInfo;

    public boolean isNull() {
        return isNull;
    }

    public void setIsNull(boolean isNull) {
        this.isNull = isNull;
    }

    private boolean isNull;
}
