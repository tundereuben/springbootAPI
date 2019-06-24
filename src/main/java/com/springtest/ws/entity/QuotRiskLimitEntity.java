package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name="quotrisklimits")
public class QuotRiskLimitEntity implements Serializable {
    private static final long serialVersionUID = -1207010007720940258L;

    @Id
    private int qrlCode;

    private BigDecimal qrlAnnualPrem;
    private BigDecimal qrlLimitAmt;
    private BigDecimal qrlPremRate;
    private BigDecimal qrlPremAmt;
    private String qrlRateType;
    private String qrlRateDesc;
    private String qrlSectType;
    private BigDecimal qrlRateDivFactor;
    private String qrlDesc;
    private String qrlDualBasis;
    private String qrlCoverType;
    private int qrlClntCode;
    private int qrlQpCode;
    private int qrlQpProCode;
    private int qrlQrCode;
    private int qrlQrQuotCode;
    private int qrlSectCode;
    private String qrlSectShtDesc;

    public int getQrlCode() {
        return qrlCode;
    }

    public void setQrlCode(int qrlCode) {
        this.qrlCode = qrlCode;
    }

    public BigDecimal getQrlAnnualPrem() {
        return qrlAnnualPrem;
    }

    public void setQrlAnnualPrem(BigDecimal qrlAnnualPrem) {
        this.qrlAnnualPrem = qrlAnnualPrem;
    }

    public BigDecimal getQrlLimitAmt() {
        return qrlLimitAmt;
    }

    public void setQrlLimitAmt(BigDecimal qrlLimitAmt) {
        this.qrlLimitAmt = qrlLimitAmt;
    }

    public BigDecimal getQrlPremRate() {
        return qrlPremRate;
    }

    public void setQrlPremRate(BigDecimal qrlPremRate) {
        this.qrlPremRate = qrlPremRate;
    }

    public BigDecimal getQrlPremAmt() {
        return qrlPremAmt;
    }

    public void setQrlPremAmt(BigDecimal qrlPremAmt) {
        this.qrlPremAmt = qrlPremAmt;
    }

    public String getQrlRateType() {
        return qrlRateType;
    }

    public void setQrlRateType(String qrlRateType) {
        this.qrlRateType = qrlRateType;
    }

    public String getQrlRateDesc() {
        return qrlRateDesc;
    }

    public void setQrlRateDesc(String qrlRateDesc) {
        this.qrlRateDesc = qrlRateDesc;
    }

    public String getQrlSectType() {
        return qrlSectType;
    }

    public void setQrlSectType(String qrlSectType) {
        this.qrlSectType = qrlSectType;
    }

    public BigDecimal getQrlRateDivFactor() {
        return qrlRateDivFactor;
    }

    public void setQrlRateDivFactor(BigDecimal qrlRateDivFactor) {
        this.qrlRateDivFactor = qrlRateDivFactor;
    }

    public String getQrlDesc() {
        return qrlDesc;
    }

    public void setQrlDesc(String qrlDesc) {
        this.qrlDesc = qrlDesc;
    }

    public String getQrlDualBasis() {
        return qrlDualBasis;
    }

    public void setQrlDualBasis(String qrlDualBasis) {
        this.qrlDualBasis = qrlDualBasis;
    }

    public String getQrlCoverType() {
        return qrlCoverType;
    }

    public void setQrlCoverType(String qrlCoverType) {
        this.qrlCoverType = qrlCoverType;
    }

    public int getQrlClntCode() {
        return qrlClntCode;
    }

    public void setQrlClntCode(int qrlClntCode) {
        this.qrlClntCode = qrlClntCode;
    }

    public int getQrlQpCode() {
        return qrlQpCode;
    }

    public void setQrlQpCode(int qrlQpCode) {
        this.qrlQpCode = qrlQpCode;
    }

    public int getQrlQpProCode() {
        return qrlQpProCode;
    }

    public void setQrlQpProCode(int qrlQpProCode) {
        this.qrlQpProCode = qrlQpProCode;
    }

    public int getQrlQrCode() {
        return qrlQrCode;
    }

    public void setQrlQrCode(int qrlQrCode) {
        this.qrlQrCode = qrlQrCode;
    }

    public int getQrlQrQuotCode() {
        return qrlQrQuotCode;
    }

    public void setQrlQrQuotCode(int qrlQrQuotCode) {
        this.qrlQrQuotCode = qrlQrQuotCode;
    }

    public int getQrlSectCode() {
        return qrlSectCode;
    }

    public void setQrlSectCode(int qrlSectCode) {
        this.qrlSectCode = qrlSectCode;
    }

    public String getQrlSectShtDesc() {
        return qrlSectShtDesc;
    }

    public void setQrlSectShtDesc(String qrlSectShtDesc) {
        this.qrlSectShtDesc = qrlSectShtDesc;
    }
}
