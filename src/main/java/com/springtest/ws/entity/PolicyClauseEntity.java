package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_clauses")
public class PolicyClauseEntity implements Serializable {
    private static final long serialVersionUID = 4002574857524944996L;

    @Id
    @Column(nullable = false, unique = true)
    private int clsCode;

    @Column(nullable = false)
    private String clsName;

    @Column(nullable = false)
    private int clsPolCode;

    private int clsSclCode;

    public int getClsCode() {
        return clsCode;
    }

    public void setClsCode(int clsCode) {
        this.clsCode = clsCode;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public int getClsPolCode() {
        return clsPolCode;
    }

    public void setClsPolCode(int clsPolCode) {
        this.clsPolCode = clsPolCode;
    }

    public int getClsSclCode() {
        return clsSclCode;
    }

    public void setClsSclCode(int clsSclCode) {
        this.clsSclCode = clsSclCode;
    }
}
