package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="sectors")
public class SectorEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long secCode;
    private String secName;

    public long getSecCode() {
        return secCode;
    }

    public void setSecCode(long secCode) {
        this.secCode = secCode;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }
}
