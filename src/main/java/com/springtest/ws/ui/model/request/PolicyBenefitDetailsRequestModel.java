package com.springtest.ws.ui.model.request;

public class PolicyBenefitDetailsRequestModel {

    private String bftName;
    private float bftRate;
    private int bftNo;
    private float bftMultBy;
    private int bftPolCode;
    private int bftSclCode;

    public String getBftName() {
        return bftName;
    }

    public void setBftName(String bftName) {
        this.bftName = bftName;
    }

    public float getBftRate() {
        return bftRate;
    }

    public void setBftRate(float bftRate) {
        this.bftRate = bftRate;
    }

    public int getBftNo() {
        return bftNo;
    }

    public void setBftNo(int bftNo) {
        this.bftNo = bftNo;
    }

    public float getBftMultBy() {
        return bftMultBy;
    }

    public void setBftMultBy(float bftMultBy) {
        this.bftMultBy = bftMultBy;
    }

    public int getBftPolCode() {
        return bftPolCode;
    }

    public void setBftPolCode(int bftPolCode) {
        this.bftPolCode = bftPolCode;
    }

    public int getBftSclCode() {
        return bftSclCode;
    }

    public void setBftSclCode(int bftSclCode) {
        this.bftSclCode = bftSclCode;
    }
}
