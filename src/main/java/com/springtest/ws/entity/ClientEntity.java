package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="clients")
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = -6916897956564344190L;

    @Id
    @GeneratedValue
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
