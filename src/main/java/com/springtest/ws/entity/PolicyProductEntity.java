package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_products")
public class PolicyProductEntity implements Serializable {
    private static final long serialVersionUID = -6009144140580813555L;
    
    @Id
    @Column(nullable = false, unique = true)
    private int sclCode;

    private String sclName;
    private int sclPolCode;

    public int getSclCode() {
        return sclCode;
    }

    public void setSclCode(int sclCode) {
        this.sclCode = sclCode;
    }

    public String getSclName() {
        return sclName;
    }

    public void setSclName(String sclName) {
        this.sclName = sclName;
    }

    public int getSclPolCode() {
        return sclPolCode;
    }

    public void setSclPolCode(int sclPolCode) {
        this.sclPolCode = sclPolCode;
    }
}
