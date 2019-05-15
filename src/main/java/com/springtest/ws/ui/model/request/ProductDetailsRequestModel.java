package com.springtest.ws.ui.model.request;

public class ProductDetailsRequestModel {

    private int proCode;
    private int proShtCode;
    private String proDesc;

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public int getProShtCode() {
        return proShtCode;
    }

    public void setProShtCode(int proShtCode) {
        this.proShtCode = proShtCode;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }
}
