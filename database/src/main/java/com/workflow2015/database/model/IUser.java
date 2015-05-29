package com.workflow2015.database.model;

/**
 * Created by Dominik Heigl on 5/29/15.
 */
public interface IUser {
    int getUserid();

    void setUserid(int userid);

    String getFirstname();

    void setFirstname(String firstname);

    String getLastname();

    void setLastname(String lastname);

    String getEmail();

    void setEmail(String email);
}
