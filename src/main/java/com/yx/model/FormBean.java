package com.yx.model;

import java.util.Date;

/**
 * User: NMY
 * Date: 17-3-11
 */
public class FormBean {
    private String name;
    private int age;
    private Date birthDate;
    private String phone;
    private int currency;
    private int percent;
    private String inquiry;
    private String inquiryDetails;
    private int[] additionalInfo;
    private String subscribeNewsletter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getInquiryDetails() {
        return inquiryDetails;
    }

    public void setInquiryDetails(String inquiryDetails) {
        this.inquiryDetails = inquiryDetails;
    }

    public int[] getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(int[] additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSubscribeNewsletter() {
        return subscribeNewsletter;
    }

    public void setSubscribeNewsletter(String subscribeNewsletter) {
        this.subscribeNewsletter = subscribeNewsletter;
    }
}
