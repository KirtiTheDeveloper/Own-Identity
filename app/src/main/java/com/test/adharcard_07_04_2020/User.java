package com.test.adharcard_07_04_2020;

public class User {
    private String fname;
    private String lname;
    private String faname;
    private String city;
    private String state;
    private String landmark;
    private String sector;
    private String houseno;
    private String pincode;
    private String ph;
    private String email;
    private String dob;
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }



    public User(String fname, String lname, String faname, String city, String state, String landmark, String sector, String houseno, String pincode, String ph,String email,String dob) {
        this.fname = fname;
        this.lname = lname;
        this.faname = faname;
        this.city = city;

        this.state = state;
        this.landmark = landmark;
        this.sector = sector;
        this.houseno = houseno;
        this.pincode = pincode;
        this.ph = ph;
        this.email = email;
        this.dob=dob;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFaname() {
        return faname;
    }

    public void setFaname(String faname) {
        this.faname = faname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
