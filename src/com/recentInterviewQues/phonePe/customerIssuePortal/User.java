package com.recentInterviewQues.phonePe.customerIssuePortal;

public class User {
    private String name;
    private String email;
    private String mobileNo;
    private UserRole userRole;


    public User(String email, String name, String mobileNo, UserRole userRole) {
        this.email = email;
        this.name = name;
        this.mobileNo = mobileNo;
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
