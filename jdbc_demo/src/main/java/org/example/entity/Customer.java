package org.example.entity;

import java.util.Date;

public class Customer {
    private String fullName;
    private Date birthDate;
    private String gender;
    private String emailAddress;
    private String education;
    private String phone;
    private String AddressLine1;
    private String AddressLine2;

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", AddressLine1='" + AddressLine1 + '\'' +
                ", AddressLine2='" + AddressLine2 + '\'' +
                '}';
    }

    public Customer(String fullName, Date birthDate, String gender, String emailAddress, String education, String phone, String addressLine1, String addressLine2) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.education = education;
        this.phone = phone;
        AddressLine1 = addressLine1;
        AddressLine2 = addressLine2;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }
}
