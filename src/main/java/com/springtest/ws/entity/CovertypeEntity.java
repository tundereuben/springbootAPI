package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="covertypes")
public class CovertypeEntity implements Serializable {
    private static final long serialVersionUID = 3078592516706220110L;

    @Id
    private  int covtCode;

    @Column(nullable = false)
    private String covtShtDesc;

    private String covtDesc;

    @Column(nullable = false)
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
