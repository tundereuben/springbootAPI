package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class PolicySubclassDto implements Serializable {
    private static final long serialVersionUID = 6168141093734660534L;

    private int sclCode;
    private String sclName;
    private int sclPolCode;

    public int getSclCode() {
        return sclCode;
    }

    public void setSclCode(int sclCode) {
        this.sclCode = sclCode;
    }

    public String getSclName() {
        return sclName;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    public int getSclPolCode() {
        return sclPolCode;
    }

    public void setSclPolCode(int sclPolCode) {
        this.sclPolCode = sclPolCode;
    }
}
