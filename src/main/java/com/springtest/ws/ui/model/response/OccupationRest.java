package com.springtest.ws.ui.model.response;

public class OccupationRest {

    private long occCode;
//    private long occSecCode;
//    private String occShortDesc;
    private String occName;

    public long getOccCode() {
        return occCode;
    }

    public void setOccCode(long occCode) {
        this.occCode = occCode;
    }

//    public long getOccSecCode() {
//        return occSecCode;
//    }
//
//    public void setOccSecCode(long occSecCode) {
//        this.occSecCode = occSecCode;
//    }

//    public String getOccShortDesc() {
//        return occShortDesc;
//    }
//
//    public void setOccShortDesc(String occShortDesc) {
//        this.occShortDesc = occShortDesc;
//    }

    public String getOccName() {
        return occName;
    }

    public void setOccName(String occName) {
        this.occName = occName;
    }
}
