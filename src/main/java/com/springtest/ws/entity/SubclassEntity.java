package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="subclasses")
public class SubclassEntity implements Serializable {
    private static final long serialVersionUID = -6009144140580813555L;

//
//    @GeneratedValue
//    private long id;

    @Id
    @Column(nullable = false, unique = true)
    private int sclCode;

    @Column(nullable = false)
    private int sclClaCode;

    @Column(nullable = false)
    private String sclDesc;

    @Column(nullable = false)
    private String sclShtDesc;
    

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
