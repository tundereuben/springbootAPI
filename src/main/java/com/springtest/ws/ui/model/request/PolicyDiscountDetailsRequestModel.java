package com.springtest.ws.ui.model.request;

import java.math.BigDecimal;

public class PolicyDiscountDetailsRequestModel {

    private String dsctName;
    private String dsctType;
    private String dsctCalcOn;
    private int dsctPolCode;
    private BigDecimal dsctDefaultValue;

    public String getDsctName() {
        return dsctName;
    }

    public void setDsctName(String dsctName) {
        this.dsctName = dsctName;
    }

    public String getDsctType() {
        return dsctType;
    }

    public void setDsctType(String dsctType) {
        this.dsctType = dsctType;
    }

    public String getDsctCalcOn() {
        return dsctCalcOn;
    }

    public void setDsctCalcOn(String dsctCalcOn) {
        this.dsctCalcOn = dsctCalcOn;
    }

    public int getDsctPolCode() {
        return dsctPolCode;
    }

    public void setDsctPolCode(int dsctPolCode) {
        this.dsctPolCode = dsctPolCode;
    }

    public BigDecimal getDsctDefaultValue() {
        return dsctDefaultValue;
    }

    public void setDsctDefaultValue(BigDecimal dsctDefaultValue) {
        this.dsctDefaultValue = dsctDefaultValue;
    }
}
