package com.springtest.ws.ui.model.response;

public class PolicyLoadingRest {

    private int loadCode;
    private String loadName;
    private String loadType;
    private String loadCalcOn;
    private int loadPolCode;

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
}
