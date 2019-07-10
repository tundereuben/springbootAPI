package com.springtest.ws.ui.model.response;

import java.math.BigDecimal;

public class PolicyDiscountRest {

    private int dsctCode;
    private String dsctName;
    private String dsctType;
    private String dsctCalcOn;
    private int dsctPolCode;
    private BigDecimal dsctDefaultValue;

    public int getDsctCode() {
        return dsctCode;
    }

    public void setDsctCode(int dsctCode) {
        this.dsctCode = dsctCode;
    }

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
