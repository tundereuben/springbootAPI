package com.springtest.ws.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuotRiskLimitDto implements Serializable {
    private static final long serialVersionUID = -576911881765871788L;

    private int qrlCode;
    private BigDecimal qrlActualPrem;
    private BigDecimal qrlAnnualPrem;
    private int qrlCalcGroup;
    private BigDecimal qrlLimitAmt;
    private BigDecimal qrlPremRate;
    private BigDecimal qrlPremAmt;
    private String qrlRateType;
    private String qrlRateDesc;
    private String qrlSectType;
    private String qrlSectExcessDetail;
    private BigDecimal qrlOriginalPremRate;
    private String qrlRateChangeRemarks;
    private String qrlChangeDoneBy;
    private BigDecimal qrlMinPremium;
    private String qrlComment;
    private BigDecimal qrlMultiplierRate;
    private BigDecimal qrlMultiplierDivFactor;
    private BigDecimal qrlAnnualPremium;
    private BigDecimal qrlRateDivFactor;
    private String qrlDesc;
    private BigDecimal qrlUsedLimit;
    private String qrlCompute;
    private BigDecimal qrlIndemPrd;
    private String qrlPrdType;
    private BigDecimal qrlIndemFstprd;
    private BigDecimal qrlIndemFstprdPct;
    private BigDecimal qrlIndemRemprdPct;
    private String qrlDualBasis;
    private BigDecimal qrlPremAccumulation;
    private BigDecimal qrlPremProrata;
    private BigDecimal qrlPrevPrem;
    private String qrlDeclarationSection;
    private BigDecimal qrlPrevLimit;
    private BigDecimal qrlPrevPremProrata;
    private BigDecimal qrlAnnualActualPrem;
    private int qrlEmlPct;
    private int qrlTopLocRate;
    private int qrlTopLocDivFact;
    private BigDecimal qrlFreeLimitAmt;
    private int qrlLimitPrd;
    private BigDecimal qrlActualRatePrem;
    private BigDecimal qrlPrevEndrPremRate;
    private BigDecimal qrlPrevEndrRateDivFact;
    private BigDecimal qrlPrevEndrMultRate;
    private BigDecimal qrlqrlPrevEndrMultDivFact;
    private String qrlExpired;
    private BigDecimal qrlFreeLimit;
    private String qrlProrataFull;
    private String qrlSiLimitType;
    private BigDecimal qrlSiRate;
    private String qrlCoverType;
    private BigDecimal qrlPrrMaxRate;
    private BigDecimal qrlPrrMinRate;
    private String qrlFirstloss;
    private String qrlFirstlossAmtPcnt;
    private int qrlFirstlossValue;
    private int qrlIsEditable;
    private int qrlIpuCode;
    private BigDecimal qrlMaxPremRate;
    private  BigDecimal qrlMinPremRate;
    private int qrlQpCode;
    private int qrlQpProCode;
    private int qrlQrCode;
    private int qrlQrQuotCode;
    private int qrlRowNum;
    private int qrlSectCode;
    private String qrlSectShtDesc;
    private int qrlSetupPremRate;

    public int getQrlCode() {
        return qrlCode;
    }

    public void setQrlCode(int qrlCode) {
        this.qrlCode = qrlCode;
    }

    public BigDecimal getQrlActualPrem() {
        return qrlActualPrem;
    }

    public void setQrlActualPrem(BigDecimal qrlActualPrem) {
        this.qrlActualPrem = qrlActualPrem;
    }

    public BigDecimal getQrlAnnualPrem() {
        return qrlAnnualPrem;
    }

    public void setQrlAnnualPrem(BigDecimal qrlAnnualPrem) {
        this.qrlAnnualPrem = qrlAnnualPrem;
    }

    public int getQrlCalcGroup() {
        return qrlCalcGroup;
    }

    public void setQrlCalcGroup(int qrlCalcGroup) {
        this.qrlCalcGroup = qrlCalcGroup;
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

    public String getQrlSectExcessDetail() {
        return qrlSectExcessDetail;
    }

    public void setQrlSectExcessDetail(String qrlSectExcessDetail) {
        this.qrlSectExcessDetail = qrlSectExcessDetail;
    }

    public BigDecimal getQrlOriginalPremRate() {
        return qrlOriginalPremRate;
    }

    public void setQrlOriginalPremRate(BigDecimal qrlOriginalPremRate) {
        this.qrlOriginalPremRate = qrlOriginalPremRate;
    }

    public String getQrlRateChangeRemarks() {
        return qrlRateChangeRemarks;
    }

    public void setQrlRateChangeRemarks(String qrlRateChangeRemarks) {
        this.qrlRateChangeRemarks = qrlRateChangeRemarks;
    }

    public String getQrlChangeDoneBy() {
        return qrlChangeDoneBy;
    }

    public void setQrlChangeDoneBy(String qrlChangeDoneBy) {
        this.qrlChangeDoneBy = qrlChangeDoneBy;
    }

    public BigDecimal getQrlMinPremium() {
        return qrlMinPremium;
    }

    public void setQrlMinPremium(BigDecimal qrlMinPremium) {
        this.qrlMinPremium = qrlMinPremium;
    }

    public String getQrlComment() {
        return qrlComment;
    }

    public void setQrlComment(String qrlComment) {
        this.qrlComment = qrlComment;
    }

    public BigDecimal getQrlMultiplierRate() {
        return qrlMultiplierRate;
    }

    public void setQrlMultiplierRate(BigDecimal qrlMultiplierRate) {
        this.qrlMultiplierRate = qrlMultiplierRate;
    }

    public BigDecimal getQrlMultiplierDivFactor() {
        return qrlMultiplierDivFactor;
    }

    public void setQrlMultiplierDivFactor(BigDecimal qrlMultiplierDivFactor) {
        this.qrlMultiplierDivFactor = qrlMultiplierDivFactor;
    }

    public BigDecimal getQrlAnnualPremium() {
        return qrlAnnualPremium;
    }

    public void setQrlAnnualPremium(BigDecimal qrlAnnualPremium) {
        this.qrlAnnualPremium = qrlAnnualPremium;
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

    public BigDecimal getQrlUsedLimit() {
        return qrlUsedLimit;
    }

    public void setQrlUsedLimit(BigDecimal qrlUsedLimit) {
        this.qrlUsedLimit = qrlUsedLimit;
    }

    public String getQrlCompute() {
        return qrlCompute;
    }

    public void setQrlCompute(String qrlCompute) {
        this.qrlCompute = qrlCompute;
    }

    public BigDecimal getQrlIndemPrd() {
        return qrlIndemPrd;
    }

    public void setQrlIndemPrd(BigDecimal qrlIndemPrd) {
        this.qrlIndemPrd = qrlIndemPrd;
    }

    public String getQrlPrdType() {
        return qrlPrdType;
    }

    public void setQrlPrdType(String qrlPrdType) {
        this.qrlPrdType = qrlPrdType;
    }

    public BigDecimal getQrlIndemFstprd() {
        return qrlIndemFstprd;
    }

    public void setQrlIndemFstprd(BigDecimal qrlIndemFstprd) {
        this.qrlIndemFstprd = qrlIndemFstprd;
    }

    public BigDecimal getQrlIndemFstprdPct() {
        return qrlIndemFstprdPct;
    }

    public void setQrlIndemFstprdPct(BigDecimal qrlIndemFstprdPct) {
        this.qrlIndemFstprdPct = qrlIndemFstprdPct;
    }

    public BigDecimal getQrlIndemRemprdPct() {
        return qrlIndemRemprdPct;
    }

    public void setQrlIndemRemprdPct(BigDecimal qrlIndemRemprdPct) {
        this.qrlIndemRemprdPct = qrlIndemRemprdPct;
    }

    public String getQrlDualBasis() {
        return qrlDualBasis;
    }

    public void setQrlDualBasis(String qrlDualBasis) {
        this.qrlDualBasis = qrlDualBasis;
    }

    public BigDecimal getQrlPremAccumulation() {
        return qrlPremAccumulation;
    }

    public void setQrlPremAccumulation(BigDecimal qrlPremAccumulation) {
        this.qrlPremAccumulation = qrlPremAccumulation;
    }

    public BigDecimal getQrlPremProrata() {
        return qrlPremProrata;
    }

    public void setQrlPremProrata(BigDecimal qrlPremProrata) {
        this.qrlPremProrata = qrlPremProrata;
    }

    public BigDecimal getQrlPrevPrem() {
        return qrlPrevPrem;
    }

    public void setQrlPrevPrem(BigDecimal qrlPrevPrem) {
        this.qrlPrevPrem = qrlPrevPrem;
    }

    public String getQrlDeclarationSection() {
        return qrlDeclarationSection;
    }

    public void setQrlDeclarationSection(String qrlDeclarationSection) {
        this.qrlDeclarationSection = qrlDeclarationSection;
    }

    public BigDecimal getQrlPrevLimit() {
        return qrlPrevLimit;
    }

    public void setQrlPrevLimit(BigDecimal qrlPrevLimit) {
        this.qrlPrevLimit = qrlPrevLimit;
    }

    public BigDecimal getQrlPrevPremProrata() {
        return qrlPrevPremProrata;
    }

    public void setQrlPrevPremProrata(BigDecimal qrlPrevPremProrata) {
        this.qrlPrevPremProrata = qrlPrevPremProrata;
    }

    public BigDecimal getQrlAnnualActualPrem() {
        return qrlAnnualActualPrem;
    }

    public void setQrlAnnualActualPrem(BigDecimal qrlAnnualActualPrem) {
        this.qrlAnnualActualPrem = qrlAnnualActualPrem;
    }

    public int getQrlEmlPct() {
        return qrlEmlPct;
    }

    public void setQrlEmlPct(int qrlEmlPct) {
        this.qrlEmlPct = qrlEmlPct;
    }

    public int getQrlTopLocRate() {
        return qrlTopLocRate;
    }

    public void setQrlTopLocRate(int qrlTopLocRate) {
        this.qrlTopLocRate = qrlTopLocRate;
    }

    public int getQrlTopLocDivFact() {
        return qrlTopLocDivFact;
    }

    public void setQrlTopLocDivFact(int qrlTopLocDivFact) {
        this.qrlTopLocDivFact = qrlTopLocDivFact;
    }

    public BigDecimal getQrlFreeLimitAmt() {
        return qrlFreeLimitAmt;
    }

    public void setQrlFreeLimitAmt(BigDecimal qrlFreeLimitAmt) {
        this.qrlFreeLimitAmt = qrlFreeLimitAmt;
    }

    public int getQrlLimitPrd() {
        return qrlLimitPrd;
    }

    public void setQrlLimitPrd(int qrlLimitPrd) {
        this.qrlLimitPrd = qrlLimitPrd;
    }

    public BigDecimal getQrlActualRatePrem() {
        return qrlActualRatePrem;
    }

    public void setQrlActualRatePrem(BigDecimal qrlActualRatePrem) {
        this.qrlActualRatePrem = qrlActualRatePrem;
    }

    public BigDecimal getQrlPrevEndrPremRate() {
        return qrlPrevEndrPremRate;
    }

    public void setQrlPrevEndrPremRate(BigDecimal qrlPrevEndrPremRate) {
        this.qrlPrevEndrPremRate = qrlPrevEndrPremRate;
    }

    public BigDecimal getQrlPrevEndrRateDivFact() {
        return qrlPrevEndrRateDivFact;
    }

    public void setQrlPrevEndrRateDivFact(BigDecimal qrlPrevEndrRateDivFact) {
        this.qrlPrevEndrRateDivFact = qrlPrevEndrRateDivFact;
    }

    public BigDecimal getQrlPrevEndrMultRate() {
        return qrlPrevEndrMultRate;
    }

    public void setQrlPrevEndrMultRate(BigDecimal qrlPrevEndrMultRate) {
        this.qrlPrevEndrMultRate = qrlPrevEndrMultRate;
    }

    public BigDecimal getQrlqrlPrevEndrMultDivFact() {
        return qrlqrlPrevEndrMultDivFact;
    }

    public void setQrlqrlPrevEndrMultDivFact(BigDecimal qrlqrlPrevEndrMultDivFact) {
        this.qrlqrlPrevEndrMultDivFact = qrlqrlPrevEndrMultDivFact;
    }

    public String getQrlExpired() {
        return qrlExpired;
    }

    public void setQrlExpired(String qrlExpired) {
        this.qrlExpired = qrlExpired;
    }

    public BigDecimal getQrlFreeLimit() {
        return qrlFreeLimit;
    }

    public void setQrlFreeLimit(BigDecimal qrlFreeLimit) {
        this.qrlFreeLimit = qrlFreeLimit;
    }

    public String getQrlProrataFull() {
        return qrlProrataFull;
    }

    public void setQrlProrataFull(String qrlProrataFull) {
        this.qrlProrataFull = qrlProrataFull;
    }

    public String getQrlSiLimitType() {
        return qrlSiLimitType;
    }

    public void setQrlSiLimitType(String qrlSiLimitType) {
        this.qrlSiLimitType = qrlSiLimitType;
    }

    public BigDecimal getQrlSiRate() {
        return qrlSiRate;
    }

    public void setQrlSiRate(BigDecimal qrlSiRate) {
        this.qrlSiRate = qrlSiRate;
    }

    public String getQrlCoverType() {
        return qrlCoverType;
    }

    public void setQrlCoverType(String qrlCoverType) {
        this.qrlCoverType = qrlCoverType;
    }

    public BigDecimal getQrlPrrMaxRate() {
        return qrlPrrMaxRate;
    }

    public void setQrlPrrMaxRate(BigDecimal qrlPrrMaxRate) {
        this.qrlPrrMaxRate = qrlPrrMaxRate;
    }

    public BigDecimal getQrlPrrMinRate() {
        return qrlPrrMinRate;
    }

    public void setQrlPrrMinRate(BigDecimal qrlPrrMinRate) {
        this.qrlPrrMinRate = qrlPrrMinRate;
    }

    public String getQrlFirstloss() {
        return qrlFirstloss;
    }

    public void setQrlFirstloss(String qrlFirstloss) {
        this.qrlFirstloss = qrlFirstloss;
    }

    public String getQrlFirstlossAmtPcnt() {
        return qrlFirstlossAmtPcnt;
    }

    public void setQrlFirstlossAmtPcnt(String qrlFirstlossAmtPcnt) {
        this.qrlFirstlossAmtPcnt = qrlFirstlossAmtPcnt;
    }

    public int getQrlFirstlossValue() {
        return qrlFirstlossValue;
    }

    public void setQrlFirstlossValue(int qrlFirstlossValue) {
        this.qrlFirstlossValue = qrlFirstlossValue;
    }

    public int getQrlIsEditable() {
        return qrlIsEditable;
    }

    public void setQrlIsEditable(int qrlIsEditable) {
        this.qrlIsEditable = qrlIsEditable;
    }

    public int getQrlIpuCode() {
        return qrlIpuCode;
    }

    public void setQrlIpuCode(int qrlIpuCode) {
        this.qrlIpuCode = qrlIpuCode;
    }

    public BigDecimal getQrlMaxPremRate() {
        return qrlMaxPremRate;
    }

    public void setQrlMaxPremRate(BigDecimal qrlMaxPremRate) {
        this.qrlMaxPremRate = qrlMaxPremRate;
    }

    public BigDecimal getQrlMinPremRate() {
        return qrlMinPremRate;
    }

    public void setQrlMinPremRate(BigDecimal qrlMinPremRate) {
        this.qrlMinPremRate = qrlMinPremRate;
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

    public int getQrlRowNum() {
        return qrlRowNum;
    }

    public void setQrlRowNum(int qrlRowNum) {
        this.qrlRowNum = qrlRowNum;
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

    public int getQrlSetupPremRate() {
        return qrlSetupPremRate;
    }

    public void setQrlSetupPremRate(int qrlSetupPremRate) {
        this.qrlSetupPremRate = qrlSetupPremRate;
    }
}
