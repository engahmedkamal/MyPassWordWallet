package com.isfp.ahmed.mypasswordwallet.model;

/**
 * Created by ahmed on 18/11/16.
 */

public class User {
    private int id;
    private String username;
    private String passWord;
    private String firstname;
    private String lastname;

    public User() {

    }

    public User(String username, String passWord) {
        this.username=username;
        this.passWord=passWord;
    }

    public User(String username, String passWord, String firstname, String lastname) {
        this.username=username;
        this.passWord=passWord;
        this.firstname=firstname;
        this.lastname=lastname;
    }

    public User(int id,String username, String passWord, String firstname, String lastname) {
        this.id=id;
        this.username=username;
        this.passWord=passWord;
        this.firstname=firstname;
        this.lastname=lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
}
