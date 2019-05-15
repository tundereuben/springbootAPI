package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="sections")
public class SectionEntity implements Serializable {
    private static final long serialVersionUID = -1631121377126049579L;

    @Id
    private int sectCode;

    @Column(nullable = false)
    private String sectShtDesc;

    @Column(nullable = false)
    private String sectDesc;

    @Column(nullable = false)
    private String sectType;

    public int getSectCode() {
        return sectCode;
    }

    public void setSectCode(int sectCode) {
        this.sectCode = sectCode;
    }

    public String getSectShtDesc() {
        return sectShtDesc;
    }

    public void setSectShtDesc(String sectShtDesc) {
        this.sectShtDesc = sectShtDesc;
    }

    public String getSectDesc() {
        return sectDesc;
    }

    public void setSectDesc(String sectDesc) {
        this.sectDesc = sectDesc;
    }

    public String getSectType() {
        return sectType;
    }

    public void setSectType(String sectType) {
        this.sectType = sectType;
    }
}
