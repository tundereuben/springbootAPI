package com.springtest.ws.ui.model.request;

public class ClientDetailsRequestModel {

    private String clntEmail;
    private String clntMobile;
    private String clntFirstname;
    private String clntMiddlename;
    private String clntLastname;

    public String getClntEmail() {
        return clntEmail;
    }

    public void setClntEmail(String clntEmail) {
        this.clntEmail = clntEmail;
    }

    public String getClntMobile() {
        return clntMobile;
    }

    public void setClntMobile(String clntMobile) {
        this.clntMobile = clntMobile;
    }

    public String getClntFirstname() {
        return clntFirstname;
    }

    public void setClntFirstname(String clntFirstname) {
        this.clntFirstname = clntFirstname;
    }

    public String getClntMiddlename() {
        return clntMiddlename;
    }

    public void setClntMiddlename(String clntMiddlename) {
        this.clntMiddlename = clntMiddlename;
    }

    public String getClntLastname() {
        return clntLastname;
    }

    public void setClntLastname(String clntLastname) {
        this.clntLastname = clntLastname;
    }
}
