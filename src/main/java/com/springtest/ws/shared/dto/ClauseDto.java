package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class ClauseDto implements Serializable {
    private static final long  serialVersionUID = 2805544114123285681L;

    private int clsCode;
    private String clsShtDesc;
    private String clsHeading;
    private String clsWording;
    private String clsType;

    public int getClsCode() {
        return clsCode;
    }

    public void setClsCode(int clsCode) {
        this.clsCode = clsCode;
    }

    public String getClsShtDesc() {
        return clsShtDesc;
    }

    public void setClsShtDesc(String clsShtDesc) {
        this.clsShtDesc = clsShtDesc;
    }

    public String getClsHeading() {
        return clsHeading;
    }

    public void setClsHeading(String clsHeading) {
        this.clsHeading = clsHeading;
    }

    public String getClsWording() {
        return clsWording;
    }

    public void setClsWording(String clsWording) {
        this.clsWording = clsWording;
    }

    public String getClsType() {
        return clsType;
    }

    public void setClsType(String clsType) {
        this.clsType = clsType;
    }
}
