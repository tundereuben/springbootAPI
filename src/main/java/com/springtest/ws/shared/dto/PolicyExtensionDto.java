package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class PolicyExtensionDto implements Serializable {
    private static final long serialVersionUID = 5415073877827234398L;

    private int extCode;
    private String extName;
    private int extPolCode;
    private int extSclCode;

    public int getExtCode() {
        return extCode;
    }

    public void setExtCode(int extCode) {
        this.extCode = extCode;
    }

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
