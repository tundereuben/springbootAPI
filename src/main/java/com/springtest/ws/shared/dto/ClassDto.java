package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class ClassDto implements Serializable {
    private static final long serialVersionUID = -2331320568424105159L;

    private long id;
    private int claCode;
    private String claDesc;
    private  String claShtDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClaCode() {
        return claCode;
    }

    public void setClaCode(int claCode) {
        this.claCode = claCode;
    }

    public String getClaDesc() {
        return claDesc;
    }

    public void setClaDesc(String claDesc) {
        this.claDesc = claDesc;
    }

    public String getClaShtDesc() {
        return claShtDesc;
    }

    public void setClaShtDesc(String claShtDesc) {
        this.claShtDesc = claShtDesc;
    }
}
