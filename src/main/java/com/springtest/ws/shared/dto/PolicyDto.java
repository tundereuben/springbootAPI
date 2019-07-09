package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class PolicyDto implements Serializable {
    private static final long serialVersionUID = -3386665669974066418L;

    private long polCode;
    private String polName;
    private String polClaName;
    private String polSclName;

    public long getPolCode() {
        return polCode;
    }

    public void setPolCode(long polCode) {
        this.polCode = polCode;
    }

    public String getPolName() {
        return polName;
    }

    public void setPolName(String polName) {
        this.polName = polName;
    }

    public String getPolClaName() {
        return polClaName;
    }

    public void setPolClaName(String polClaName) {
        this.polClaName = polClaName;
    }

    public String getPolSclName() {
        return polSclName;
    }

    public void setPolSclName(String polSclName) {
        this.polSclName = polSclName;
    }
}
