package com.springtest.ws.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QuotProductDto implements Serializable {
    private static final long serialVersionUID = -3701791978869045309L;

    public int qpCode;
    public int qpProCode;
    public String qpProShtDesc;
    public Date qpWefDate;
    public Date qpWetDate;
    public int qpQuotCode;
    public String qpQuotNo;
    public int qpQuotRevisionNo;
    public BigDecimal qpTotalSi;
    public BigDecimal qpPremium;
    public BigDecimal qpComm;
    public String qpRemarks;
    public BigDecimal qpFap;
    public String qpStatus;
    public String qpBinder;
    public int qpBindCode;
    public BigDecimal qpSubCommAmt;
    public String qpConverted;
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

    public int getQpQuotRevisionNo() {
        return qpQuotRevisionNo;
    }

    public void setQpQuotRevisionNo(int qpQuotRevisionNo) {
        this.qpQuotRevisionNo = qpQuotRevisionNo;
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

    public String getQpRemarks() {
        return qpRemarks;
    }

    public void setQpRemarks(String qpRemarks) {
        this.qpRemarks = qpRemarks;
    }

    public BigDecimal getQpFap() {
        return qpFap;
    }

    public void setQpFap(BigDecimal qpFap) {
        this.qpFap = qpFap;
    }

    public String getQpStatus() {
        return qpStatus;
    }

    public void setQpStatus(String qpStatus) {
        this.qpStatus = qpStatus;
    }

    public String getQpBinder() {
        return qpBinder;
    }

    public void setQpBinder(String qpBinder) {
        this.qpBinder = qpBinder;
    }

    public int getQpBindCode() {
        return qpBindCode;
    }

    public void setQpBindCode(int qpBindCode) {
        this.qpBindCode = qpBindCode;
    }

    public BigDecimal getQpSubCommAmt() {
        return qpSubCommAmt;
    }

    public void setQpSubCommAmt(BigDecimal qpSubCommAmt) {
        this.qpSubCommAmt = qpSubCommAmt;
    }

    public String getQpConverted() {
        return qpConverted;
    }

    public void setQpConverted(String qpConverted) {
        this.qpConverted = qpConverted;
    }

//    public int getQpAgntCode() {
//        return qpAgntCode;
//    }
//
//    public void setQpAgntCode(int qpAgntCode) {
//        this.qpAgntCode = qpAgntCode;
//    }
}
