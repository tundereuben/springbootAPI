package com.springtest.ws.ui.model.request;

public class PolicyCommissionDetailsRequestModel {
    private String commName;
    private String commType;
    private String commCalcOn;
    private int commPolCode;

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
}
