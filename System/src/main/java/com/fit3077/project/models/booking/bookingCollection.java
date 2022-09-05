/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fit3077.project.models.booking;

import com.fit3077.project.models.testingSite.testingSite;

/**
 * An interface for the bookingAPICollection class to extend from
 */
public interface bookingCollection {
    
    /**
     * Method which returns a booking through its ID
     */
    public Booking getBookingByID(String ID);
    
    /**
     * Method which returns a booking through its QR code
     */
    public Booking getBookingByQR(String QRcode);
    
    /**
     * Method which returns a booking through its PIN code
     */
    public Booking getBookingByPIN(String PINcode);
    
    /**
     * Method which returns bookings of a given user
     */
    public Booking[] getBookingsByUsername(String username);
    
    /**
     * Method which returns all bookings in system
     */
    public Booking[] getAllBookings();
    
    /**
     * Method which returns the total waiting time for a given testing site
     */
    public int getWaitingTime(testingSite site, String date);
    
    /**
     * Method which checks if the current bookings matched the one stored in the server.
     * If the bookings don't match, the bookings will be reloaded.
     * An enum object will be returned, the object describes the changes in the server's data
     */
    public bookingNotification reloadBookings();
    
    /**
     * Getter method which returns the booking which was previously modified, added or deleted
     */
    public Booking getRecentBooking();
 
    /**
     * Getter method which returns the testing site ID of the booking before it was modified
     */
    public String getPreviousBookingSiteID();
    
}
