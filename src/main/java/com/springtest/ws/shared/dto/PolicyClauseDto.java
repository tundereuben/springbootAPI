package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class PolicyClauseDto implements Serializable {
    private static final long  serialVersionUID = 2805544114123285681L;

    private int clsCode;
    private String clsName;
    private int clsPolCode;
    private int clsSclCode;

    public int getClsCode() {
        return clsCode;
    }

    public void setClsCode(int clsCode) {
        this.clsCode = clsCode;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public int getClsPolCode() {
        return clsPolCode;
    }

    public void setClsPolCode(int clsPolCode) {
        this.clsPolCode = clsPolCode;
    }

    public int getClsSclCode() {
        return clsSclCode;
    }

    public void setClsSclCode(int clsSclCode) {
        this.clsSclCode = clsSclCode;
    }
}
