package com.springtest.ws.ui.model.request;

import java.math.BigDecimal;

public class PolicyRateDetailsRequestModel {

    private String rateName;
    private BigDecimal rateDefaultValue;
    private int ratePolCode;
    private int rateSclCode;

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public BigDecimal getRateDefaultValue() {
        return rateDefaultValue;
    }

    public void setRateDefaultValue(BigDecimal rateDefaultValue) {
        this.rateDefaultValue = rateDefaultValue;
    }

    public int getRatePolCode() {
        return ratePolCode;
    }

    public void setRatePolCode(int ratePolCode) {
        this.ratePolCode = ratePolCode;
    }

    public int getRateSclCode() {
        return rateSclCode;
    }

    public void setRateSclCode(int rateSclCode) {
        this.rateSclCode = rateSclCode;
    }
}
