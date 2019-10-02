package com.springtest.ws.ui.model.response;

import java.math.BigDecimal;
import java.util.Date;

public class QuotProductRest {

    public int qpCode;
    public int qpProCode;
    public String qpName;
    public Date qpWefDate;
    public Date qpWetDate;
    public int qpQuotCode;
    public String qpQuotNo;
    public BigDecimal qpTotalSi;
    public BigDecimal qpPremium;
    public BigDecimal qpComm;
//    public int qpAgntCode;
    public String qpClauses;



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

    public String getQpName() {
        return qpName;
    }

    public void setQpName(String qpName) {
        this.qpName = qpName;
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


    public String getQpClauses() {
        return qpClauses;
    }

    public void setQpClauses(String qpClauses) {
        this.qpClauses = qpClauses;
    }
}
