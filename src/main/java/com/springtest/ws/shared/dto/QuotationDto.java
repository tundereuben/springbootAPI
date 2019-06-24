package com.springtest.ws.shared.dto;

import java.io.Serializable;
import java.util.Date;

public class QuotationDto implements Serializable {
    private static final long serialVersionUID = -9193025225396704642L;

    public int quotCode;
    public String quotNo;
    public int quotClntCode;
    public int quotAgntCode;
    public String quotSource;
    public String quotBranch;
    public String quotCurSymbol;
    public Date quotCoverFrom;
    public Date quotCoverTo;
    public String quotPaymentFrequency;
    public Date quotDate;

    public int getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(int quotCode) {
        this.quotCode = quotCode;
    }

    public String getQuotNo() {
        return quotNo;
    }

    public void setQuotNo(String quotNo) {
        this.quotNo = quotNo;
    }

    public int getQuotClntCode() {
        return quotClntCode;
    }

    public void setQuotClntCode(int quotClntCode) {
        this.quotClntCode = quotClntCode;
    }

    public int getQuotAgntCode() {
        return quotAgntCode;
    }

    public void setQuotAgntCode(int quotAgntCode) {
        this.quotAgntCode = quotAgntCode;
    }

    public String getQuotSource() {
        return quotSource;
    }

    public void setQuotSource(String quotSource) {
        this.quotSource = quotSource;
    }

    public String getQuotBranch() {
        return quotBranch;
    }

    public void setQuotBranch(String quotBranch) {
        this.quotBranch = quotBranch;
    }

    public String getQuotCurSymbol() {
        return quotCurSymbol;
    }

    public void setQuotCurSymbol(String quotCurSymbol) {
        this.quotCurSymbol = quotCurSymbol;
    }

    public Date getQuotCoverFrom() {
        return quotCoverFrom;
    }

    public void setQuotCoverFrom(Date quotCoverFrom) {
        this.quotCoverFrom = quotCoverFrom;
    }

    public Date getQuotCoverTo() {
        return quotCoverTo;
    }

    public void setQuotCoverTo(Date quotCoverTo) {
        this.quotCoverTo = quotCoverTo;
    }

    public String getQuotPaymentFrequency() {
        return quotPaymentFrequency;
    }

    public void setQuotPaymentFrequency(String quotPaymentFrequency) {
        this.quotPaymentFrequency = quotPaymentFrequency;
    }

    public Date getQuotDate() {
        return quotDate;
    }

    public void setQuotDate(Date quotDate) {
        this.quotDate = quotDate;
    }
}
