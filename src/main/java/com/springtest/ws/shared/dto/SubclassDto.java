package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class SubclassDto implements Serializable {
    private static final long serialVersionUID = 6168141093734660534L;

    private long id;
    private int sclCode;
    private int sclClaCode;
    private String sclDesc;
    private String sclShtDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSclCode() {
        return sclCode;
    }

    public void setSclCode(int sclCode) {
        this.sclCode = sclCode;
    }

    public int getSclClaCode() {
        return sclClaCode;
    }

    public void setSclClaCode(int sclClaCode) {
        this.sclClaCode = sclClaCode;
    }

    public String getSclDesc() {
        return sclDesc;
    }

    public void setSclDesc(String sclDesc) {
        this.sclDesc = sclDesc;
    }

    public String getSclShtDesc() {
        return sclShtDesc;
    }

    public void setSclShtDesc(String sclShtDesc) {
        this.sclShtDesc = sclShtDesc;
    }
}
