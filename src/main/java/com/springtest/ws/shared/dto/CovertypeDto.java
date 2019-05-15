package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class CovertypeDto implements Serializable {
    private static final long serialVersionUID = 6430701001408427222L;
    
    private  int covtCode;
    private String covtShtDesc;
    private String covtDesc;
    private String covtDetails;

    public int getCovtCode() {
        return covtCode;
    }

    public void setCovtCode(int covtCode) {
        this.covtCode = covtCode;
    }

    public String getCovtShtDesc() {
        return covtShtDesc;
    }

    public void setCovtShtDesc(String covtShtDesc) {
        this.covtShtDesc = covtShtDesc;
    }

    public String getCovtDesc() {
        return covtDesc;
    }

    public void setCovtDesc(String covtDesc) {
        this.covtDesc = covtDesc;
    }

    public String getCovtDetails() {
        return covtDetails;
    }

    public void setCovtDetails(String covtDetails) {
        this.covtDetails = covtDetails;
    }
}
