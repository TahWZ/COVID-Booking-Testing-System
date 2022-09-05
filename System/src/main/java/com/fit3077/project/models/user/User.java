/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.user;

/**
 * Class which represents the user
 */
public class User {
    private String givenName, familyName, username, phoneNumber, ID;

    /**
     * Constructor method for the user class
     */
    public User(String ID, String givenName, String familyName, String username, String phoneNumber) {
        this.ID = ID;
        this.givenName = givenName;
        this.familyName = familyName;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Method which return the full name of the user
     */
    public String getFullName() {
        return givenName + " " + familyName;
    }
    
    /**
     * Getter method which returns the user's ID
     */
    public String getID(){
        return ID;
    }
    
    /**
     * Getter method which returns the user's given name
     */
    public String getGivenName() {
        return givenName;
    }
    
    /**
     * Getter method which returns the user's family name
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Getter method which returns the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method which returns the user's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
