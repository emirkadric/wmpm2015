package com.workflow2015.database.model;

/**
 * Created by Dominik Heigl on 5/29/15.
 */
public interface IUser {
    int getId();

    void setId(int id);

    String getFirstname();

    void setFirstname(String firstname);

    String getLastname();

    void setLastname(String lastname);

    String getEmail();

    void setEmail(String email);

    Boolean getSubscribed();

    void setSubscribed(Boolean subscribed);
}
