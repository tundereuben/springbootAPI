package com.springtest.ws.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PolicyCommissionDto implements Serializable {
    private static final long serialVersionUID = -4924218607666527164L;

    private int commCode;
    private String commName;
    private String commType;
    private String commCalcOn;
    private int commPolCode;
    private BigDecimal commDefaultValue;
    private BigDecimal commVat;
    private int commSclCode;

    public int getCommCode() {
        return commCode;
    }

    public void setCommCode(int commCode) {
        this.commCode = commCode;
    }

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

    public BigDecimal getCommVat() {
        return commVat;
    }

    public void setCommVat(BigDecimal commVat) {
        this.commVat = commVat;
    }

    public int getCommSclCode() {
        return commSclCode;
    }

    public void setCommSclCode(int commSclCode) {
        this.commSclCode = commSclCode;
    }
}
