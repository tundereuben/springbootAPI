package com.springtest.ws.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PolicyLoadingDto implements Serializable {
    public static final long serialVersionUID = -5992167021410650855L;

    private int loadCode;
    private String loadName;
    private String loadType;
    private String loadCalcOn;
    private int loadPolCode;
    private BigDecimal loadDefaultValue;
    private int loadSclCode;

    public int getLoadCode() {
        return loadCode;
    }

    public void setLoadCode(int loadCode) {
        this.loadCode = loadCode;
    }

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

    public int getLoadSclCode() {
        return loadSclCode;
    }

    public void setLoadSclCode(int loadSclCode) {
        this.loadSclCode = loadSclCode;
    }
}
