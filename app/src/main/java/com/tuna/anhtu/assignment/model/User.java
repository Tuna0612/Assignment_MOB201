package com.tuna.anhtu.assignment.model;

public class User {

    private String mName;
    private String mDate;
    private String mHome;
    private String mPhone;

    public User() {
    }

    public User(String mName, String mDate, String mHome, String mPhone) {
        this.mName = mName;
        this.mDate = mDate;
        this.mHome = mHome;
        this.mPhone = mPhone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmHome() {
        return mHome;
    }

    public void setmHome(String mHome) {
        this.mHome = mHome;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
