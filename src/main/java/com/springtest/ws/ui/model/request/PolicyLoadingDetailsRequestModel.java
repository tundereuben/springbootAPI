package com.springtest.ws.ui.model.request;

import java.math.BigDecimal;

public class PolicyLoadingDetailsRequestModel {

    private String loadName;
    private String loadType;
    private String loadCalcOn;
    private int loadPolCode;
    private BigDecimal loadDefaultValue;

    public String getLoadName() {
        return loadName;
    }

    public void setLoadName(String loadName) {
        this.loadName = loadName;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getLoadCalcOn() {
        return loadCalcOn;
    }

    public void setLoadCalcOn(String loadCalcOn) {
        this.loadCalcOn = loadCalcOn;
    }

    public int getLoadPolCode() {
        return loadPolCode;
    }

    public void setLoadPolCode(int loadPolCode) {
        this.loadPolCode = loadPolCode;
    }

    public BigDecimal getLoadDefaultValue() {
        return loadDefaultValue;
    }

    public void setLoadDefaultValue(BigDecimal loadDefaultValue) {
        this.loadDefaultValue = loadDefaultValue;
    }
}
