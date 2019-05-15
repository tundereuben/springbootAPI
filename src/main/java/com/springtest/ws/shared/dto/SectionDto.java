package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class SectionDto implements Serializable {
    private static final long serialVersionUID = 6813132744418130807L;

    private int sectCode;
    private String sectDesc;
    private String sectShtDesc;
    private String sectType;

    public int getSectCode() {
        return sectCode;
    }

    public void setSectCode(int sectCode) {
        this.sectCode = sectCode;
    }

    public String getSectDesc() {
        return sectDesc;
    }

    public void setSectDesc(String sectDesc) {
        this.sectDesc = sectDesc;
    }

    public String getSectShtDesc() {
        return sectShtDesc;
    }

    public void setSectShtDesc(String sectShtDesc) {
        this.sectShtDesc = sectShtDesc;
    }

    public String getSectType() {
        return sectType;
    }

    public void setSectType(String sectType) {
        this.sectType = sectType;
    }
}
