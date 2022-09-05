/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.user;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The class which is responsible for storing the user objects and providing methods to retrieve them. 
 */
public class userAPICollection implements userCollection{
    
    private User[] users;
    private static userAPICollection uCollection = null;
    
    /**
     * Constructor method for the userAPICollection class
     */
    private userAPICollection(){
        convertToUser(userAPI.getUsers());
    }
    
    /**
     * Method which retrieves the Singleton instance of this class
     */
    public static userAPICollection getInstance(){
        if (uCollection == null){
            uCollection = new userAPICollection();
        }
        return uCollection;
    }
    
    /**
     * Parses the JSON object retrieved from the user database, and converts it to booking objects 
     */
    public void convertToUser(ObjectNode[] data){
        users = new User[data.length];
        for (int i=0;i<data.length;i++){
            users[i] = userFactory.createUser(
                    data[i].get("id").textValue(),
                    data[i].get("givenName").textValue(),
                    data[i].get("familyName").textValue(),
                    data[i].get("userName").textValue(),
                    data[i].get("phoneNumber").textValue(),
                    data[i].get("isCustomer").asBoolean(),
                    data[i].get("isReceptionist").asBoolean(),
                    data[i].get("isHealthcareWorker").asBoolean()
            );
        }
    }
    
    /**
     * Method which returns an instance of a user through their username
     */
    @Override 
    public User getUserByUserName(String username){
        for (User u: users){
            if (u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
    
    /**
     * Method which returns an instance of a user through their user ID
     */
    @Override
    public User getUserByUserID(String ID){
        for (User u: users){
            if (u.getID().equals(ID)){
                return u;
            }
        }
        return null;
    }
}
