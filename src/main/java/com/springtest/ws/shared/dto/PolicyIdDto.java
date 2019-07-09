package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class PolicyIdDto implements Serializable {
    private static final long serialVersionUID = 3190921855073637581L;
    
    private int idCode;
    private String idName;
    private String idType;
    private int idPolCode;

    public int getIdCode() {
        return idCode;
    }

    public void setIdCode(int idCode) {
        this.idCode = idCode;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public int getIdPolCode() {
        return idPolCode;
    }

    public void setIdPolCode(int idPolCode) {
        this.idPolCode = idPolCode;
    }
}
