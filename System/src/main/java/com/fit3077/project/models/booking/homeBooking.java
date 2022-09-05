/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.booking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.user.User;

/**
 * A booking class that is meant to represent home bookings. It extends from the booking class
 */
public class homeBooking extends Booking {
    private String URL;

    /**
     * Constructor method for the homeBooking class
     */    
    public homeBooking(String ID, User patient, testingSite bookSite, String dateTime, String bookDate, String bookTime, String bookNotes, bookingStatus bookStatus, String smsPin, JsonNode additions) {
        super(ID, patient, bookSite, dateTime, bookDate, bookTime, bookNotes, bookStatus, smsPin, additions);
        this.URL = additions.get("URL").toString();
    }

    /**
     * Getter method which returns the URL for the home booking
     */
    public String getURL() {
        return URL;
    }
}
