package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="countries")
public class CountryEntity implements Serializable{
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue
    private long couCode;
    private String couName;

    public long getCouCode() {
        return couCode;
    }

    public void setCouCode(long couCode) {
        this.couCode = couCode;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }
}
