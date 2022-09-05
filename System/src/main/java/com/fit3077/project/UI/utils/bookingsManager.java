/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.UI.utils;

import com.fit3077.project.models.booking.bookingNotification;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the listeners subscribed and invokes their shared method
 * @author User
 */
public class bookingsManager {
    private List<bookingsListener> listeners = new ArrayList<bookingsListener>();
    
    /**
     * Adds a new subscriber
     */
    public void subscribe(bookingsListener newListener){
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
    public void notify(bookingNotification bNotification){
        for (bookingsListener l:listeners){
            l.refreshBookings(bNotification);
        }
    }
}
