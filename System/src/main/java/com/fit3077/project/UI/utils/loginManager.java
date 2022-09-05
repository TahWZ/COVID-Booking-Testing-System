/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.UI.utils;

import com.fit3077.project.models.user.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the listeners subscribed and invokes their shared method
 * @author User
 */
public class loginManager {
    private List<loginListener> listeners = new ArrayList<loginListener>();
    
    /**
     * Adds a new subscriber
     */
    public void subscribe(loginListener newListener){
        listeners.add(newListener);
    }
    
    /**
     * Removes all subscribers
     */
    public void unsubscribeAll(){
        listeners.clear();
    } 
    
    /**
     * Notifies all subscribers
     */
    public void notify(User newUser){
        for (loginListener l:listeners){
            l.updateUser(newUser);
        }
    }
}
