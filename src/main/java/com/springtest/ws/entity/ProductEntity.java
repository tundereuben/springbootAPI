package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="products")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = -2295969824172886274L;

    @Id
    @Column(nullable = false, length = 32, unique = true)
    private int proCode;

    @Column(nullable = false)
    private int proShtDesc;

    @Column(nullable = false)
    private String proDesc;

    public int getProCode() {
        return proCode;
    }

    public void setProCode(int proCode) {
        this.proCode = proCode;
    }

    public int getProShtDesc() {
        return proShtDesc;
    }

    public void setProShtDesc(int proShtDesc) {
        this.proShtDesc = proShtDesc;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }
}
