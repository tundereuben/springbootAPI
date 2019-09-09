package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class SectorDto implements Serializable {
    private static final long serialVersionUID = 1L;

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
