package com.springtest.ws.ui.model.request;

import java.math.BigDecimal;

public class PolicyCommissionDetailsRequestModel {
    private String commName;
    private String commType;
    private String commCalcOn;
    private int commPolCode;
    private BigDecimal commDefaultValue;
    private int commSclCode;

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public String getCommCalcOn() {
        return commCalcOn;
    }

    public void setCommCalcOn(String commCalcOn) {
        this.commCalcOn = commCalcOn;
    }

    public int getCommPolCode() {
        return commPolCode;
    }

    public void setCommPolCode(int commPolCode) {
        this.commPolCode = commPolCode;
    }

    public BigDecimal getCommDefaultValue() {
        return commDefaultValue;
    }

    public void setCommDefaultValue(BigDecimal commDefaultValue) {
        this.commDefaultValue = commDefaultValue;
    }

    public int getCommSclCode() {
        return commSclCode;
    }

    public void setCommSclCode(int commSclCode) {
        this.commSclCode = commSclCode;
    }
}
