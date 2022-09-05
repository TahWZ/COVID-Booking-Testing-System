/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.booking.memento;

import com.fit3077.project.models.booking.bookingStatus;

/**
 * Class which represents the memento that stores the state of a booking
 * @author User
 */
public class bookingMemento {
    
    private String bookingID, startTime, testingSiteID, lastModificationTime;
    private bookingStatus status;

    /**
     * Constructor method for the booking memento class
     */   
    public bookingMemento(String bookingID, bookingStatus status, String startTime, String testingSiteID, String lastModificationTime) {
        this.bookingID = bookingID;
        this.status = status;
        this.startTime = startTime;
        this.testingSiteID = testingSiteID;
        this.lastModificationTime = lastModificationTime;
    }
    
    /**
     * Getter method which returns the booking ID
     */  
    public String getBookingID() {
        return bookingID;
    }
    
    /**
     * Getter method which returns the status of the booking
     */
    public bookingStatus getStatus() {
        return status;
    }

    /**
     * Getter method which returns the date and time for the booking
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Getter method which returns the testing site for the booking
     */
    public String getTestingSiteID() {
        return testingSiteID;
    }

    /**
     * Getter method which returns the last time the booking was modified
     */     
    public String getLastModificationTime() {
        return lastModificationTime;
    }
    
    
}
