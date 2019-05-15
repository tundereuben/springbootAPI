package com.springtest.ws.ui.model.response;

public class SectionRest {
    public int sectCode;
    public String sectShtDesc;
    public String sectDesc;
    public String sectType;

    public int getSectCode() {
        return sectCode;
    }

    public void setSectCode(int sectCode) {
        this.sectCode = sectCode;
    }

    public String getSectShtDesc() {
        return sectShtDesc;
    }

    public void setSectShtDesc(String sectShtDesc) {
        this.sectShtDesc = sectShtDesc;
    }

    public String getSectDesc() {
        return sectDesc;
    }

    public void setSectDesc(String sectDesc) {
        this.sectDesc = sectDesc;
    }

    public String getSectType() {
        return sectType;
    }

    public void setSectType(String sectType) {
        this.sectType = sectType;
    }
}
