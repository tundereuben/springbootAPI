package com.springtest.ws.ui.model.request;

public class SectorDetailsRequestModel {
    private long secCode;
    private String secName;

    public long getSecCode() {
        return secCode;
    }

    public void setSecCode(long secCode) {
        this.secCode = secCode;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }
}
