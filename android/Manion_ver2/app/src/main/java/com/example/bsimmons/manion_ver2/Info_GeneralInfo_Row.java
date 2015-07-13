package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */
class Row {

    private String desc;
    private String info;

    public Row(String desc, String info){
        this.desc = desc;
        this.info = info;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    public void setInfo(String info ) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
}