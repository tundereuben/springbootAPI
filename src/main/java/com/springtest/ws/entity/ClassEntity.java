package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="classes")
public class ClassEntity implements Serializable {

    private static final long serialVersionUID = 6958001598788899697L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 32, unique = true)
    private int claCode;

    @Column(nullable = false, length = 64)
    private String claDesc;

    @Column(nullable = false, length = 64)
    private String claShtDesc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClaCode() {
        return claCode;
    }

    public void setClaCode(int claCode) {
        this.claCode = claCode;
    }

    public String getClaDesc() {
        return claDesc;
    }

    public void setClaDesc(String claDesc) {
        this.claDesc = claDesc;
    }

    public String getClaShtDesc() {
        return claShtDesc;
    }

    public void setClaShtDesc(String claShtDesc) {
        this.claShtDesc = claShtDesc;
    }
}
