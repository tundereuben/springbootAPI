package com.springtest.ws.ui.model.request;

public class SectionDetailsRequestModel {
    public int sectCode;
    public String sectDesc;
    public String sectShtDesc;
    public String sectType;

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
