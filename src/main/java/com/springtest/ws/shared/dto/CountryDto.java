package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class CountryDto implements Serializable{
    private static final long serailVersionUID = 1L;

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
