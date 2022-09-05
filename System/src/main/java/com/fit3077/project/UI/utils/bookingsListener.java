/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fit3077.project.UI.utils;

import com.fit3077.project.models.booking.bookingNotification;

/**
 * Subscriber's interface for the bookingsManager observer class
 * @author User
 */

public interface bookingsListener {
    
    /**
     * Refreshes bookings
     */
    public void refreshBookings(bookingNotification bNotifications);
}
