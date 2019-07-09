package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="policies")
public class PolicyEntity implements Serializable {
    private static final long serialVersionUID = -3080810154628830864L;

    @Id
    private long polCode;

    @Column()
    private String polName;

    @Column()
    private String polClaName;

    @Column()
    private String polSclName;

    public long getPolCode() {
        return polCode;
    }

    public void setPolCode(long polCode) {
        this.polCode = polCode;
    }

    public String getPolName() {
        return polName;
    }

    public void setPolName(String polName) {
        this.polName = polName;
    }

    public String getPolClaName() {
        return polClaName;
    }

    public void setPolClaName(String polClaName) {
        this.polClaName = polClaName;
    }

    public String getPolSclName() {
        return polSclName;
    }

    public void setPolSclName(String polSclName) {
        this.polSclName = polSclName;
    }
}
