package com.springtest.ws.ui.model.request;

public class PolicyProductDetailsRequestModel {

//    private int sclCode;
    private String sclName;
    private int sclPolCode;

   
    public String getSclName() {
        return sclName;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    public int getSclPolCode() {
        return sclPolCode;
    }

    public void setSclPolCode(int sclPolCode) {
        this.sclPolCode = sclPolCode;
    }
}
