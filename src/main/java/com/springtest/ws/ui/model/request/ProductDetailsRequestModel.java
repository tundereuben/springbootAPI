package com.springtest.ws.ui.model.request;

public class ProductDetailsRequestModel {

    private int proCode;
    private int proShtDesc;
    private String proDesc;

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public int getProShtDesc() {
        return proShtDesc;
    }

    public void setProShtDesc(int proShtDesc) {
        this.proShtDesc = proShtDesc;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }
}
