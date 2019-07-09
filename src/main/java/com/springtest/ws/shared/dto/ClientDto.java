package com.springtest.ws.shared.dto;

import java.io.Serializable;

public class ClientDto implements Serializable {
    private static final long serialVersionUID = -7112699217253404976L;

    private long clntCode;
    private String clntEmail;
    private String clntMobile;
    private String clntFirstname;
    private String clntMiddlename;
    private String clntLastname;

    public long getClntCode() {
        return clntCode;
    }

    public void setClntCode(long clntCode) {
        this.clntCode = clntCode;
    }

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
