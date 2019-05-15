package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="clauses")
public class ClauseEntity implements Serializable {
    private static final long serialVersionUID = 4002574857524944996L;

    @Id
    @Column(nullable = false, unique = true)
    private int clsCode;

    @Column(nullable = false)
    private String clsShtDesc;

    @Column(nullable = false)
    private String clsHeading;

    @Column(nullable = false)
    private String clsWording;

    @Column(nullable = false)
    private String clsType;

    public int getClsCode() {
        return clsCode;
    }

    public void setClsCode(int clsCode) {
        this.clsCode = clsCode;
    }

    public String getClsShtDesc() {
        return clsShtDesc;
    }

    public void setClsShtDesc(String clsShtDesc) {
        this.clsShtDesc = clsShtDesc;
    }

    public String getClsHeading() {
        return clsHeading;
    }

    public void setClsHeading(String clsHeading) {
        this.clsHeading = clsHeading;
    }

    public String getClsWording() {
        return clsWording;
    }

    public void setClsWording(String clsWording) {
        this.clsWording = clsWording;
    }

    public String getClsType() {
        return clsType;
    }

    public void setClsType(String clsType) {
        this.clsType = clsType;
    }
}
