package com.nguessan.script;

/**
 * Created by Nguessan on 12/19/2015.
 */
public class Contacts {

    String username, email, password,latitude,longitude;


    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {return this.username;}

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setLatitude(String latitude){this.latitude = latitude;}

    public String getLatitude() {return this.latitude;}

    public void setLongitude(String longitude){this.longitude = longitude;}

    public String getLongitude() {return this.longitude;}

}