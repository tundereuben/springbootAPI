package com.springtest.ws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="underwriters")
public class UnderwriterEntity implements Serializable{
    private static final long serialVersionUID =1L ;

    @Id
    @GeneratedValue
    private long undCode;
    private String undCompanyName;
    private String undPostalAddress;
    private int undPostalCode;
    private String undCity;
    private String undState;
    private String undCountry;
    private String undMobile;
    private String undEmail;
    private String undVatNo;
    private String undTaxIdNo;
    private String undPencomNo;
    private String undWebsite;
    private String undPaymentMethod;
    private String undBankName;
    private String undBankBranch;
    private String undAccountNo;
    private String undSortCode;
    private String undRegNo;

    public long getUndCode() {
        return undCode;
    }

    public void setUndCode(long undCode) {
        this.undCode = undCode;
    }

    public String getUndCompanyName() {
        return undCompanyName;
    }

    public void setUndCompanyName(String undCompanyName) {
        this.undCompanyName = undCompanyName;
    }

    public String getUndPostalAddress() {
        return undPostalAddress;
    }

    public void setUndPostalAddress(String undPostalAddress) {
        this.undPostalAddress = undPostalAddress;
    }

    public int getUndPostalCode() {
        return undPostalCode;
    }

    public void setUndPostalCode(int undPostalCode) {
        this.undPostalCode = undPostalCode;
    }

    public String getUndCity() {
        return undCity;
    }

    public void setUndCity(String undCity) {
        this.undCity = undCity;
    }

    public String getUndState() {
        return undState;
    }

    public void setUndState(String undState) {
        this.undState = undState;
    }

    public String getUndCountry() {
        return undCountry;
    }

    public void setUndCountry(String undCountry) {
        this.undCountry = undCountry;
    }

    public String getUndMobile() {
        return undMobile;
    }

    public void setUndMobile(String undMobile) {
        this.undMobile = undMobile;
    }

    public String getUndEmail() {
        return undEmail;
    }

    public void setUndEmail(String undEmail) {
        this.undEmail = undEmail;
    }

    public String getUndVatNo() {
        return undVatNo;
    }

    public void setUndVatNo(String undVatNo) {
        this.undVatNo = undVatNo;
    }

    public String getUndTaxIdNo() {
        return undTaxIdNo;
    }

    public void setUndTaxIdNo(String undTaxIdNo) {
        this.undTaxIdNo = undTaxIdNo;
    }

    public String getUndPencomNo() {
        return undPencomNo;
    }

    public void setUndPencomNo(String undPencomNo) {
        this.undPencomNo = undPencomNo;
    }

    public String getUndWebsite() {
        return undWebsite;
    }

    public void setUndWebsite(String undWebsite) {
        this.undWebsite = undWebsite;
    }

    public String getUndPaymentMethod() {
        return undPaymentMethod;
    }

    public void setUndPaymentMethod(String undPaymentMethod) {
        this.undPaymentMethod = undPaymentMethod;
    }

    public String getUndBankName() {
        return undBankName;
    }

    public void setUndBankName(String undBankName) {
        this.undBankName = undBankName;
    }

    public String getUndBankBranch() {
        return undBankBranch;
    }

    public void setUndBankBranch(String undBankBranch) {
        this.undBankBranch = undBankBranch;
    }

    public String getUndAccountNo() {
        return undAccountNo;
    }

    public void setUndAccountNo(String undAccountNo) {
        this.undAccountNo = undAccountNo;
    }

    public String getUndSortCode() {
        return undSortCode;
    }

    public void setUndSortCode(String undSortCode) {
        this.undSortCode = undSortCode;
    }

    public String getUndRegNo() {
        return undRegNo;
    }

    public void setUndRegNo(String undRegNo) {
        this.undRegNo = undRegNo;
    }
}
