package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name="pol_rates")
public class PolicyRateEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private int rateCode;
    private String rateName;
    private BigDecimal rateDefaultValue;
    private int ratePolCode;
    private int rateSclCode;

    public int getRateCode() {
        return rateCode;
    }

    public void setRateCode(int rateCode) {
        this.rateCode = rateCode;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public BigDecimal getRateDefaultValue() {
        return rateDefaultValue;
    }

    public void setRateDefaultValue(BigDecimal rateDefaultValue) {
        this.rateDefaultValue = rateDefaultValue;
    }

    public int getRatePolCode() {
        return ratePolCode;
    }

    public void setRatePolCode(int ratePolCode) {
        this.ratePolCode = ratePolCode;
    }

    public int getRateSclCode() {
        return rateSclCode;
    }

    public void setRateSclCode(int rateSclCode) {
        this.rateSclCode = rateSclCode;
    }
}
