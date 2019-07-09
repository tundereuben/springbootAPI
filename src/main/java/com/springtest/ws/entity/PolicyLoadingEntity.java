package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_loadings")
public class PolicyLoadingEntity implements Serializable {
    private static final long serialVersionUID = 2299014693758707277L;

    @Id
    private int loadCode;
    private String loadName;
    private String loadType;
    private String loadCalcOn;
    private int loadPolCode;

    public int getLoadCode() {
        return loadCode;
    }

    public void setLoadCode(int loadCode) {
        this.loadCode = loadCode;
    }

    public String getLoadName() {
        return loadName;
    }

    public void setLoadName(String loadName) {
        this.loadName = loadName;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getLoadCalcOn() {
        return loadCalcOn;
    }

    public void setLoadCalcOn(String loadCalcOn) {
        this.loadCalcOn = loadCalcOn;
    }

    public int getLoadPolCode() {
        return loadPolCode;
    }

    public void setLoadPolCode(int loadPolCode) {
        this.loadPolCode = loadPolCode;
    }
}
