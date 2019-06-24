package com.springtest.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name="quotproducts")
public class QuotProductEntity implements Serializable {
    private static final long serialVersionUID = 6367332741635466467L;

    @Id
    public int qpCode;

    @Column(nullable = false)
    public int qpProCode;

    public String qpProShtDesc;
    public Date qpWefDate;
    public Date qpWetDate;
    public int qpQuotCode;
    public String qpQuotNo;
    public BigDecimal qpTotalSi;
    public BigDecimal qpPremium;
    public BigDecimal qpComm;
//    public int qpAgntCode;

    public int getQpCode() {
        return qpCode;
    }

    public void setQpCode(int qpCode) {
        this.qpCode = qpCode;
    }

    public int getQpProCode() {
        return qpProCode;
    }

    public void setQpProCode(int qpProCode) {
        this.qpProCode = qpProCode;
    }

    public String getQpProShtDesc() {
        return qpProShtDesc;
    }

    public void setQpProShtDesc(String qpProShtDesc) {
        this.qpProShtDesc = qpProShtDesc;
    }

    public Date getQpWefDate() {
        return qpWefDate;
    }

    public void setQpWefDate(Date qpWefDate) {
        this.qpWefDate = qpWefDate;
    }

    public Date getQpWetDate() {
        return qpWetDate;
    }

    public void setQpWetDate(Date qpWetDate) {
        this.qpWetDate = qpWetDate;
    }

    public int getQpQuotCode() {
        return qpQuotCode;
    }

    public void setQpQuotCode(int qpQuotCode) {
        this.qpQuotCode = qpQuotCode;
    }

    public String getQpQuotNo() {
        return qpQuotNo;
    }

    public void setQpQuotNo(String qpQuotNo) {
        this.qpQuotNo = qpQuotNo;
    }

    public BigDecimal getQpTotalSi() {
        return qpTotalSi;
    }

    public void setQpTotalSi(BigDecimal qpTotalSi) {
        this.qpTotalSi = qpTotalSi;
    }

    public BigDecimal getQpPremium() {
        return qpPremium;
    }

    public void setQpPremium(BigDecimal qpPremium) {
        this.qpPremium = qpPremium;
    }

    public BigDecimal getQpComm() {
        return qpComm;
    }

    public void setQpComm(BigDecimal qpComm) {
        this.qpComm = qpComm;
    }

//    public int getQpAgntCode() {
//        return qpAgntCode;
//    }
//
//    public void setQpAgntCode(int qpAgntCode) {
//        this.qpAgntCode = qpAgntCode;
//    }
}
