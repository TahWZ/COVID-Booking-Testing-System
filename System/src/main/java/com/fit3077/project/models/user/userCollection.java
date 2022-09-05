/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fit3077.project.models.user;

/**
 * An interface for the userAPICollection class to extend from
 */
public interface userCollection {
    
    /**
     * Method which returns an instance of a user through their username
     */
    public User getUserByUserName(String username);
    
    /**
     * Method which returns an instance of a user through their user ID
     */
    public User getUserByUserID(String ID);
    
}
