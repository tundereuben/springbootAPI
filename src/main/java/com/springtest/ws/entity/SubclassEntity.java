package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="subclasses")
public class SubclassEntity implements Serializable {
    private static final long serialVersionUID = -6009144140580813555L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 32, unique = true)
    private int sclCode;

    @Column(nullable = false, length = 32)
    private int sclClaCode;

    @Column(nullable = false)
    private String sclDesc;

    @Column(nullable = false)
    private String sclShtDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSclCode() {
        return sclCode;
    }

    public void setSclCode(int sclCode) {
        this.sclCode = sclCode;
    }

    public int getSclClaCode() {
        return sclClaCode;
    }

    public void setSclClaCode(int sclClaCode) {
        this.sclClaCode = sclClaCode;
    }

    public String getSclDesc() {
        return sclDesc;
    }

    public void setSclDesc(String sclDesc) {
        this.sclDesc = sclDesc;
    }

    public String getSclShtDesc() {
        return sclShtDesc;
    }

    public void setSclShtDesc(String sclShtDesc) {
        this.sclShtDesc = sclShtDesc;
    }
}
