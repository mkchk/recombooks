package com.recombooks;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.recombooks.database.DatabaseConnector;

public class Member {

    public int memberID;

    public boolean isActive;

    private String zipcode;

    public String emailAddress;

    private String fullname;

    private String password;

    private boolean isVerified;

    public String lastActivity;

    public int locationID;

    public String userName;

    public Set<Integer>  ips = new HashSet<>();

    public String loginCookieID;

    public Member(boolean isActive){
        this.isActive = true;
    }

    public Member(){
        this.isActive = true;
    }

    public void populateMainFields(DatabaseConnector dbConn,
            Application application) {

        this.isActive = true;
        this.memberID = dbConn.getInt("memberID");
        this.fullname = dbConn.getFieldByName("FullName");
        this.emailAddress = dbConn.getFieldByName("EmailAddress");
        this.password = dbConn.getFieldByName("Password");
        //this.isVerified = dbConn.getBoolean("IsVerified");

    }

    public boolean isActive(){
        return isActive;
    }

    public String getLoginCookieID() {
        return loginCookieID;
    }

    public void setLoginCookieID(String loginCookieID) {
        this.loginCookieID = loginCookieID;
    }

}
