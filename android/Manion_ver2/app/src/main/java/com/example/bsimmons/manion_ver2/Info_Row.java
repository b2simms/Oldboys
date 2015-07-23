package com.example.bsimmons.manion_ver2;

/**
 * Created by bsimmons on 10/07/2015.
 */
public class Info_Row {

    private String desc;
    private String info;
    private String[] sList;
    private boolean header;

    public Info_Row(String desc, String info){
        this.desc = desc;
        this.info = info;
    }

    public Info_Row(String desc, String info, boolean header)
    {
        this.desc = desc;
        this.info = info;
        this.header = header;
    }

    public Info_Row(String[] sList){
        this.sList = sList;
    }

    public String getDesc() {
        return desc;
    }
    public String getInfo() { return info; }
    public String[] getList(){
        return sList;
    }
    public boolean getHeader() {
        return header;
    }

}