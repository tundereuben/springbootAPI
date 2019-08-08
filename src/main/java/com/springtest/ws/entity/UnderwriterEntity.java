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
    private String undTitle;
    private String undEmail;
    private String undMobile;
    private String undOthernames;
    private String undLastname;
    private String undType;
    private String undGender;
    private String undDob;
    private String undLeadDate;
    private String undCompanyName;
    private String undDescription;
    private String undSource;
    private String undSector;
    private String undOccupation;
    private String undPostalAddress;
    private int undPostalCode;
    private String undCity;
    private String undState;
    private String undCountry;
    private String undContactFirstname;
    private String undContactLastname;
    private String undContactEmail;
    private String undContactMobile;
    private String undContactBirthday;

    public long getUndCode() {
        return undCode;
    }

    public void setUndCode(long undCode) {
        this.undCode = undCode;
    }

    public String getUndTitle() {
        return undTitle;
    }

    public void setUndTitle(String undTitle) {
        this.undTitle = undTitle;
    }

    public String getUndEmail() {
        return undEmail;
    }

    public void setUndEmail(String undEmail) {
        this.undEmail = undEmail;
    }

    public String getUndMobile() {
        return undMobile;
    }

    public void setUndMobile(String undMobile) {
        this.undMobile = undMobile;
    }

    public String getUndOthernames() {
        return undOthernames;
    }

    public void setUndOthernames(String undOthernames) {
        this.undOthernames = undOthernames;
    }

    public String getUndLastname() {
        return undLastname;
    }

    public void setUndLastname(String undLastname) {
        this.undLastname = undLastname;
    }

    public String getUndType() {
        return undType;
    }

    public void setUndType(String undType) {
        this.undType = undType;
    }

    public String getUndGender() {
        return undGender;
    }

    public void setUndGender(String undGender) {
        this.undGender = undGender;
    }

    public String getUndDob() {
        return undDob;
    }

    public void setUndDob(String undDob) {
        this.undDob = undDob;
    }

    public String getUndLeadDate() {
        return undLeadDate;
    }

    public void setUndLeadDate(String undLeadDate) {
        this.undLeadDate = undLeadDate;
    }

    public String getUndCompanyName() {
        return undCompanyName;
    }

    public void setUndCompanyName(String undCompanyName) {
        this.undCompanyName = undCompanyName;
    }

    public String getUndDescription() {
        return undDescription;
    }

    public void setUndDescription(String undDescription) {
        this.undDescription = undDescription;
    }

    public String getUndSource() {
        return undSource;
    }

    public void setUndSource(String undSource) {
        this.undSource = undSource;
    }

    public String getUndSector() {
        return undSector;
    }

    public void setUndSector(String undSector) {
        this.undSector = undSector;
    }

    public String getUndOccupation() {
        return undOccupation;
    }

    public void setUndOccupation(String undOccupation) {
        this.undOccupation = undOccupation;
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

    public String getUndContactFirstname() {
        return undContactFirstname;
    }

    public void setUndContactFirstname(String undContactFirstname) {
        this.undContactFirstname = undContactFirstname;
    }

    public String getUndContactLastname() {
        return undContactLastname;
    }

    public void setUndContactLastname(String undContactLastname) {
        this.undContactLastname = undContactLastname;
    }

    public String getUndContactEmail() {
        return undContactEmail;
    }

    public void setUndContactEmail(String undContactEmail) {
        this.undContactEmail = undContactEmail;
    }

    public String getUndContactMobile() {
        return undContactMobile;
    }

    public void setUndContactMobile(String undContactMobile) {
        this.undContactMobile = undContactMobile;
    }

    public String getUndContactBirthday() {
        return undContactBirthday;
    }

    public void setUndContactBirthday(String undContactBirthday) {
        this.undContactBirthday = undContactBirthday;
    }
}
