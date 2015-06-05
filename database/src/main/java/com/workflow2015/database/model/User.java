package com.workflow2015.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Dominik Heigl on 5/29/15.
 */
@Entity
public class User implements IUser, Serializable {
    @Id
    @GeneratedValue
    private int userid;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return String.format("Id=%s, firstname=%s, lastname=%s, email=%s",
                this.getUserid(),
                this.getFirstname(),
                this.getLastname(),
                this.getEmail()
        );
    }
}

