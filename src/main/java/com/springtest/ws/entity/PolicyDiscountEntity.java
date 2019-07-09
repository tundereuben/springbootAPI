package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pol_discounts")
public class PolicyDiscountEntity implements Serializable {
    private static final long serialVersionUID = -5993528737894838956L;

    @Id
    private int dsctCode;
    
    private String dsctName;
    private String dsctType;
    private String dsctCalcOn;
    private int dsctPolCode;

    public int getDsctCode() {
        return dsctCode;
    }

    public void setDsctCode(int dsctCode) {
        this.dsctCode = dsctCode;
    }

    public String getDsctName() {
        return dsctName;
    }

    public void setDsctName(String dsctName) {
        this.dsctName = dsctName;
    }

    public String getDsctType() {
        return dsctType;
    }

    public void setDsctType(String dsctType) {
        this.dsctType = dsctType;
    }

    public String getDsctCalcOn() {
        return dsctCalcOn;
    }

    public void setDsctCalcOn(String dsctCalcOn) {
        this.dsctCalcOn = dsctCalcOn;
    }

    public int getDsctPolCode() {
        return dsctPolCode;
    }

    public void setDsctPolCode(int dsctPolCode) {
        this.dsctPolCode = dsctPolCode;
    }
}
