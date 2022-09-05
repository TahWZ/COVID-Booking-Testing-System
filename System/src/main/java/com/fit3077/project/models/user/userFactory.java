/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.user;

/**
 * A class which represents the Factory class for users
 */
public class userFactory {
    
    /**
     * Method which is responsible for instantiating the different subclasses of the user class
     */
    public static User createUser(String ID, String givenName, String familyName, String username, String phoneNumber, Boolean isCustomer, Boolean isReceptionist, Boolean isHealthcareWorker){
        if (isHealthcareWorker){
            return new healthcareWorker(ID, givenName, familyName, username, phoneNumber);            
        } else if (isReceptionist){
            return new receptionist(ID, givenName, familyName, username, phoneNumber);
        } else if (isCustomer) {
            return new customer(ID, givenName, familyName, username, phoneNumber);
        }
        return null;
    }
}
