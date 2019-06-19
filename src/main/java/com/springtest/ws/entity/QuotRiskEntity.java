package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name="quotrisks")
public class QuotRiskEntity implements Serializable {
    private static final long serialVersionUID = -6878049731732851859L;

    @Id
    public int qrCode;

    public int qrQuotCode;
    public String qrQuotNo;
    public int qrQuotRevisionNo;
    public String qrPropertyId;
    public String qrItemDesc;
    public int qrQty;
    public BigDecimal qrValue;
    public int qrSclCode;
    public int qrQpCode;
    public int qrCovtCode;
    public String qrCovtShtDesc;
    public BigDecimal qrPremium;
    public int qrBindCode;
    public Date qrWefDate;
    public Date qrWetDate;
    public int qrNcdLevel;
    public BigDecimal qrComRate;
    public BigDecimal qrCommAmt;
    //    public int qrPrpCode;
    public int qrClntCode;
//    public String qrClntShtDesc;
    public BigDecimal qrAnnualPrem;
    public int qrCoverDays;
    public String qrComment;
    public String qrEnforceCvtMinPrem;
    public String qrMinPremiumUsed;
    public BigDecimal qrFp;
    public BigDecimal qrSubCommAmt;
    public BigDecimal qrSubCommRate;
    public int qrPrsCode;
    public String qrClntType;
    public BigDecimal qrMktrComRate;
    public BigDecimal qrMktrComAmt;
    public BigDecimal qrAllowedCommRate;
    public int qrLtaCommRate;
    public int qrLtaCommAmt;
    public String qrConveyanceType;

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

    public int getQrQuotRevisionNo() {
        return qrQuotRevisionNo;
    }

    public void setQrQuotRevisionNo(int qrQuotRevisionNo) {
        this.qrQuotRevisionNo = qrQuotRevisionNo;
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

    public int getQrQty() {
        return qrQty;
    }

    public void setQrQty(int qrQty) {
        this.qrQty = qrQty;
    }

    public BigDecimal getQrValue() {
        return qrValue;
    }

    public void setQrValue(BigDecimal qrValue) {
        this.qrValue = qrValue;
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

    public String getQrCovtShtDesc() {
        return qrCovtShtDesc;
    }

    public void setQrCovtShtDesc(String qrCovtShtDesc) {
        this.qrCovtShtDesc = qrCovtShtDesc;
    }

    public BigDecimal getQrPremium() {
        return qrPremium;
    }

    public void setQrPremium(BigDecimal qrPremium) {
        this.qrPremium = qrPremium;
    }

    public int getQrBindCode() {
        return qrBindCode;
    }

    public void setQrBindCode(int qrBindCode) {
        this.qrBindCode = qrBindCode;
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

    public int getQrNcdLevel() {
        return qrNcdLevel;
    }

    public void setQrNcdLevel(int qrNcdLevel) {
        this.qrNcdLevel = qrNcdLevel;
    }

    public BigDecimal getQrComRate() {
        return qrComRate;
    }

    public void setQrComRate(BigDecimal qrComRate) {
        this.qrComRate = qrComRate;
    }

    public BigDecimal getQrCommAmt() {
        return qrCommAmt;
    }

    public void setQrCommAmt(BigDecimal qrCommAmt) {
        this.qrCommAmt = qrCommAmt;
    }

    public int getQrClntCode() {
        return qrClntCode;
    }

    public void setQrClntCode(int qrClntCode) {
        this.qrClntCode = qrClntCode;
    }

//    public String getQrClntShtDesc() {
//        return qrClntShtDesc;
//    }
//
//    public void setQrClntShtDesc(String qrClntShtDesc) {
//        this.qrClntShtDesc = qrClntShtDesc;
//    }

    public BigDecimal getQrAnnualPrem() {
        return qrAnnualPrem;
    }

    public void setQrAnnualPrem(BigDecimal qrAnnualPrem) {
        this.qrAnnualPrem = qrAnnualPrem;
    }

    public int getQrCoverDays() {
        return qrCoverDays;
    }

    public void setQrCoverDays(int qrCoverDays) {
        this.qrCoverDays = qrCoverDays;
    }

    public String getQrComment() {
        return qrComment;
    }

    public void setQrComment(String qrComment) {
        this.qrComment = qrComment;
    }

    public String getQrEnforceCvtMinPrem() {
        return qrEnforceCvtMinPrem;
    }

    public void setQrEnforceCvtMinPrem(String qrEnforceCvtMinPrem) {
        this.qrEnforceCvtMinPrem = qrEnforceCvtMinPrem;
    }

    public String getQrMinPremiumUsed() {
        return qrMinPremiumUsed;
    }

    public void setQrMinPremiumUsed(String qrMinPremiumUsed) {
        this.qrMinPremiumUsed = qrMinPremiumUsed;
    }

    public BigDecimal getQrFp() {
        return qrFp;
    }

    public void setQrFp(BigDecimal qrFp) {
        this.qrFp = qrFp;
    }

    public BigDecimal getQrSubCommAmt() {
        return qrSubCommAmt;
    }

    public void setQrSubCommAmt(BigDecimal qrSubCommAmt) {
        this.qrSubCommAmt = qrSubCommAmt;
    }

    public BigDecimal getQrSubCommRate() {
        return qrSubCommRate;
    }

    public void setQrSubCommRate(BigDecimal qrSubCommRate) {
        this.qrSubCommRate = qrSubCommRate;
    }

    public int getQrPrsCode() {
        return qrPrsCode;
    }

    public void setQrPrsCode(int qrPrsCode) {
        this.qrPrsCode = qrPrsCode;
    }

    public String getQrClntType() {
        return qrClntType;
    }

    public void setQrClntType(String qrClntType) {
        this.qrClntType = qrClntType;
    }

    public BigDecimal getQrMktrComRate() {
        return qrMktrComRate;
    }

    public void setQrMktrComRate(BigDecimal qrMktrComRate) {
        this.qrMktrComRate = qrMktrComRate;
    }

    public BigDecimal getQrMktrComAmt() {
        return qrMktrComAmt;
    }

    public void setQrMktrComAmt(BigDecimal qrMktrComAmt) {
        this.qrMktrComAmt = qrMktrComAmt;
    }

    public BigDecimal getQrAllowedCommRate() {
        return qrAllowedCommRate;
    }

    public void setQrAllowedCommRate(BigDecimal qrAllowedCommRate) {
        this.qrAllowedCommRate = qrAllowedCommRate;
    }

    public int getQrLtaCommRate() {
        return qrLtaCommRate;
    }

    public void setQrLtaCommRate(int qrLtaCommRate) {
        this.qrLtaCommRate = qrLtaCommRate;
    }

    public int getQrLtaCommAmt() {
        return qrLtaCommAmt;
    }

    public void setQrLtaCommAmt(int qrLtaCommAmt) {
        this.qrLtaCommAmt = qrLtaCommAmt;
    }

    public String getQrConveyanceType() {
        return qrConveyanceType;
    }

    public void setQrConveyanceType(String qrConveyanceType) {
        this.qrConveyanceType = qrConveyanceType;
    }
}
