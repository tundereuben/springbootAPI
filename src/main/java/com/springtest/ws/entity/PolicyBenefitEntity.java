package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_benefits")
public class PolicyBenefitEntity implements Serializable {
    private static final long serialVersionUID = 6243388024980807212L;

    @Id
    @Column(nullable = false, unique = true)
    private int bftCode;
    private String bftName;
    private float bftRate;
    private int bftNo;
    private float bftMultBy;
    private int bftPolCode;
    private int bftSclCode;

    public int getBftCode() {
        return bftCode;
    }

    public void setBftCode(int bftCode) {
        this.bftCode = bftCode;
    }

    public String getBftName() {
        return bftName;
    }

    public void setBftName(String bftName) {
        this.bftName = bftName;
    }

    public float getBftRate() {
        return bftRate;
    }

    public void setBftRate(float bftRate) {
        this.bftRate = bftRate;
    }

    public int getBftNo() {
        return bftNo;
    }

    public void setBftNo(int bftNo) {
        this.bftNo = bftNo;
    }

    public float getBftMultBy() {
        return bftMultBy;
    }

    public void setBftMultBy(float bftMultBy) {
        this.bftMultBy = bftMultBy;
    }

    public int getBftPolCode() {
        return bftPolCode;
    }

    public void setBftPolCode(int bftPolCode) {
        this.bftPolCode = bftPolCode;
    }

    public int getBftSclCode() {
        return bftSclCode;
    }

    public void setBftSclCode(int bftSclCode) {
        this.bftSclCode = bftSclCode;
    }
}
