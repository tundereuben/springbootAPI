package com.springtest.ws.ui.model.response;

public class CountryRest {
    private long couCode;
    private String couName;

    public long getCouCode() {
        return couCode;
    }

    public void setCouCode(long couCode) {
        this.couCode = couCode;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }
}
