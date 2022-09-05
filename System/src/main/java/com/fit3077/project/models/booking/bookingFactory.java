/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.booking;

import com.fasterxml.jackson.databind.JsonNode;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.user.User;

/**
 * A class which represents the Factory class for bookings
 */
public class bookingFactory {
    
    /**
     * Method which is responsible for instantiating the different subclasses of the booking class
     */
    public static Booking createBooking(String ID, User patient, testingSite bookSite, String dateTime, String bookDate, String bookTime, String bookNotes, bookingStatus bookStatus, String smsPin, JsonNode additions){
        if (additions.get("homeTest")!=null && additions.get("homeTest").asBoolean()){
            return new homeBooking(ID, patient, bookSite, dateTime, bookDate, bookTime, bookNotes, bookStatus, smsPin, additions);
        } else{
            return new Booking(ID, patient, bookSite, dateTime, bookDate, bookTime, bookNotes, bookStatus, smsPin, additions);
        }
    }
            
 
}
