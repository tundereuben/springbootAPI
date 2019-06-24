package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name="quotrisks")
public class QuotRiskEntity implements Serializable {
    private static final long serialVersionUID = -6878049731732851859L;

    @Id
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

    public int getQrClntCode() {
        return qrClntCode;
    }

    public void setQrClntCode(int qrClntCode) {
        this.qrClntCode = qrClntCode;
    }
}
