package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_ids")
public class PolicyIdEntity implements Serializable {
    private static final long serialVersionUID = -8297524214260066872L;

    @Id
    @Column(nullable = false, unique = true)
    private int idCode;

    @Column(nullable = false)
    private String idName;

    @Column(nullable = false)
    private String idType;

    @Column(nullable=false)
    private int idPolCode;

    private int idSclCode;

    public int getIdCode() {
        return idCode;
    }

    public void setIdCode(int idCode) {
        this.idCode = idCode;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public int getIdPolCode() {
        return idPolCode;
    }

    public void setIdPolCode(int idPolCode) {
        this.idPolCode = idPolCode;
    }

    public int getIdSclCode() {
        return idSclCode;
    }

    public void setIdSclCode(int idSclCode) {
        this.idSclCode = idSclCode;
    }
}
