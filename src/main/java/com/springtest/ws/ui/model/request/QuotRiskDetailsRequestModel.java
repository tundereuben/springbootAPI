package com.springtest.ws.ui.model.request;

import java.math.BigDecimal;
import java.util.Date;

public class QuotRiskDetailsRequestModel {

    public int qrCode;
    public int qrQuotCode;
    public String qrQuotNo;
    public String qrPropertyId;
    public String qrItemDesc;
    public int qrSclCode;
    public int qrQpCode;
    public int qrCovtCode;
    public Date qrWefDate;
    public Date qrWetDate;
    public int qrClntCode;
    public int qrInsuredCode;

    public BigDecimal qrSumInsured;
    public BigDecimal qrPremium;
    public BigDecimal qrCommRate;
    public BigDecimal qrCommAmount;

    public int getQrCode() {
        return qrCode;
    }

    public void setQrCode(int qrCode) {
        this.qrCode = qrCode;
    }

    public int getQrQuotCode() {
        return qrQuotCode;
    }

    public void setQrQuotCode(int qrQuotCode) {
        this.qrQuotCode = qrQuotCode;
    }

    public String getQrQuotNo() {
        return qrQuotNo;
    }

    public void setQrQuotNo(String qrQuotNo) {
        this.qrQuotNo = qrQuotNo;
    }

    public int getQrClntCode() {
        return qrClntCode;
    }

    public void setQrClntCode(int qrClntCode) {
        this.qrClntCode = qrClntCode;
    }

    public String getQrPropertyId() {
        return qrPropertyId;
    }

    public void setQrPropertyId(String qrPropertyId) {
        this.qrPropertyId = qrPropertyId;
    }

    public String getQrItemDesc() {
        return qrItemDesc;
    }

    public void setQrItemDesc(String qrItemDesc) {
        this.qrItemDesc = qrItemDesc;
    }

    public int getQrSclCode() {
        return qrSclCode;
    }

    public void setQrSclCode(int qrSclCode) {
        this.qrSclCode = qrSclCode;
    }

    public int getQrQpCode() {
        return qrQpCode;
    }

    public void setQrQpCode(int qrQpCode) {
        this.qrQpCode = qrQpCode;
    }

    public int getQrCovtCode() {
        return qrCovtCode;
    }

    public void setQrCovtCode(int qrCovtCode) {
        this.qrCovtCode = qrCovtCode;
    }

    public Date getQrWefDate() {
        return qrWefDate;
    }

    public void setQrWefDate(Date qrWefDate) {
        this.qrWefDate = qrWefDate;
    }

    public Date getQrWetDate() {
        return qrWetDate;
    }

    public void setQrWetDate(Date qrWetDate) {
        this.qrWetDate = qrWetDate;
    }

    public int getQrInsuredCode() {
        return qrInsuredCode;
    }

    public void setQrInsuredCode(int qrInsuredCode) {
        this.qrInsuredCode = qrInsuredCode;
    }

    public BigDecimal getQrSumInsured() {
        return qrSumInsured;
    }

    public void setQrSumInsured(BigDecimal qrSumInsured) {
        this.qrSumInsured = qrSumInsured;
    }

    public BigDecimal getQrPremium() {
        return qrPremium;
    }

    public void setQrPremium(BigDecimal qrPremium) {
        this.qrPremium = qrPremium;
    }

    public BigDecimal getQrCommRate() {
        return qrCommRate;
    }

    public void setQrCommRate(BigDecimal qrCommRate) {
        this.qrCommRate = qrCommRate;
    }

    public BigDecimal getQrCommAmount() {
        return qrCommAmount;
    }

    public void setQrCommAmount(BigDecimal qrCommAmount) {
        this.qrCommAmount = qrCommAmount;
    }
}
