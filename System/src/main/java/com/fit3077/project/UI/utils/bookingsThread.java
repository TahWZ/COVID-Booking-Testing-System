/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.UI.utils;

import com.fit3077.project.models.booking.bookingNotification;
import com.fit3077.project.models.booking.bookingAPICollection;
import com.fit3077.project.models.booking.bookingCollection;
import java.util.concurrent.TimeUnit;

/**
 * Thread which utilizes the observer pattern class.
 * Runs concurrently from the main application process to check and notify all
 * panels whenever a change to bookings on the Web API Service was detected
 * @author User
 */
public class bookingsThread extends Thread {
    
    Boolean pause = true; //Determines whether the thread should pause
    bookingsManager bManager; //The bookings listener manager

    public bookingsThread() {
        bManager = new bookingsManager();
    }
    
    /**
     * Run the thread concurrently from the main application process
     */
    public void run()
    {
        while(true){
            if (!pause){ //If the thread should pause
                bookingCollection bCollection = bookingAPICollection.getInstance();
                bookingNotification bNotification = bCollection.reloadBookings();
                if (bNotification != bookingNotification.NONE){
                   bManager.notify(bNotification);
                }
            }
            try {
                //Checks every 3 seconds
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e){};
        }
    }
    
    /**
     * Subscribes the given listener to the manager class
     */
    public void subscribe(bookingsListener bListener){
        bManager.subscribe(bListener);
    }
    
    /**
     *  Pauses the thread and unsubscribe all listeners
     */
    public void pauseThread(){
        pause = true;
        bManager.unsubscribeAll();
    }
    
    /**
     * Resumes the thread
     */
    public void resumeThread(){
        pause = false;
    }
}
