package com.springtest.ws.ui.model.request;

public class PolicyExtensionDetailsRequestModel {
    private String extName;
    private int extPolCode;
    private int extSclCode;

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public int getExtPolCode() {
        return extPolCode;
    }

    public void setExtPolCode(int extPolCode) {
        this.extPolCode = extPolCode;
    }

    public int getExtSclCode() {
        return extSclCode;
    }

    public void setExtSclCode(int extSclCode) {
        this.extSclCode = extSclCode;
    }
}
