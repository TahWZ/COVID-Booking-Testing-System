/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.booking;

import com.fit3077.project.models.booking.memento.bookingCaretaker;
import com.fit3077.project.models.booking.memento.bookingOriginator;
import com.fit3077.project.models.booking.memento.bookingMemento;
import com.fasterxml.jackson.databind.JsonNode;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.user.User;
import com.fit3077.project.models.testingSite.testingSiteAPICollection;
import com.fit3077.project.models.testingSite.testingSiteCollection;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Class which represents a booking
 */

public class Booking implements bookingOriginator{

    private String ID, testType, dateTime, bookDate, bookTime, bookNotes, smsPin, QRcode, lastModTime;
    private boolean homeTest;
    private User patient;
    private testingSite bookSite;
    private bookingStatus bookStatus;
    
    private bookingCaretaker bookingCaretaker;

    /**
     * Constructor method for the booking class
     */    
    public Booking(String ID, User patient, testingSite bookSite, String dateTime, String bookDate, String bookTime, String bookNotes, bookingStatus bookStatus, String smsPin, JsonNode additions) {
        this.ID = ID;
        this.patient = patient;
        this.bookSite = bookSite;
        this.dateTime = dateTime;
        this.bookDate = bookDate;
        this.bookTime = bookTime;
        this.bookNotes = bookNotes;
        this.bookStatus = bookStatus;
        this.smsPin = smsPin;
        this.bookingCaretaker = new bookingCaretaker();
        if (additions.get("QRcode") != null){
            this.QRcode = additions.get("QRcode").textValue();
            this.homeTest = additions.get("homeTest").asBoolean();
            this.testType = additions.get("testType").textValue();
            if (additions.get("lastModifiedTime") != null){
                this.lastModTime = additions.get("lastModifiedTime").textValue();
            } else {
                this.lastModTime = "";
            }
            if (additions.get("savePoint1") != null) {
                if (additions.get("savePoint1").get("bookingID") != null){
                    bookingCaretaker.saveMemento(new bookingMemento(additions.get("savePoint1").get("bookingID").textValue(), bookingStatus.valueOf(additions.get("savePoint1").get("status").textValue()),additions.get("savePoint1").get("startTime").textValue(), additions.get("savePoint1").get("testSite").textValue(), additions.get("savePoint1").get("lastModifiedTime").textValue()));
                }
                if (additions.get("savePoint2").get("bookingID") != null){
                    bookingCaretaker.saveMemento(new bookingMemento(additions.get("savePoint2").get("bookingID").textValue(), bookingStatus.valueOf(additions.get("savePoint2").get("status").textValue()),additions.get("savePoint2").get("startTime").textValue(), additions.get("savePoint2").get("testSite").textValue(), additions.get("savePoint2").get("lastModifiedTime").textValue()));
                }
                if (additions.get("savePoint3").get("bookingID") != null){
                    bookingCaretaker.saveMemento(new bookingMemento(additions.get("savePoint3").get("bookingID").textValue(), bookingStatus.valueOf(additions.get("savePoint3").get("status").textValue()),additions.get("savePoint3").get("startTime").textValue(), additions.get("savePoint3").get("testSite").textValue(), additions.get("savePoint3").get("lastModifiedTime").textValue()));
                }
            }   
        }
        Instant bookingDT = Instant.parse(dateTime);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant currentDT = timestamp.toInstant();
        if (currentDT.isAfter(bookingDT)){
            if (this.bookStatus == bookingStatus.INITIATED || this.bookStatus == bookingStatus.CONFIRMED){
                this.bookStatus = bookingStatus.LAPSED;
            }
        }
    }
    
    /**
     * Creates a booking memento (save point) in the caretaker component of the memento design pattern
     */ 
    @Override
    public void createSavepoint(String currentTime){
        bookingCaretaker.saveMemento(new bookingMemento(this.ID, this.bookStatus, this.dateTime, this.bookSite.getID(), this.lastModTime));
    }
    
    /**
     * Restores a save point from the SavePoint array
     */
    @Override
    public void undo(int savePoint){
        setOriginatorState(savePoint);
    }
    
    /**
     * Restores data from a save point from the SavePoint array
     */
    @Override
    public void setOriginatorState(int savePoint){
        bookingMemento mem = bookingCaretaker.getMemento(savePoint);
        this.ID = mem.getBookingID();
        this.bookStatus = mem.getStatus();
        this.dateTime = mem.getStartTime();
        testingSiteCollection tsCollection = testingSiteAPICollection.getInstance();
        this.bookSite = tsCollection.getTestingSiteByID(mem.getTestingSiteID());
        this.lastModTime = mem.getLastModificationTime();
    }

    /**
     * Getter method which returns the last time the booking was modified
     */  
    public String getLastModTime() {
        return lastModTime;
    }

    /**
     * Getter method which returns the booking ID
     */    
    public String getID() {
        return ID;
    }
    
    /**
     * Getter method which returns the date and time for the booking
     */
    public String getDateTime(){
        return dateTime;
    }
    
    /**
     * Getter method which returns the notes for the booking
     */
    public String getBookNotes(){
        return bookNotes;
    }

    /**
     * Getter method which returns the QR code connected to the booking
     */
    public String getQRcode() {
        return QRcode;
    }

    /**
     * Getter method which returns the test type for the booking
     */
    public String getTestType() {
        return testType;
    }

    /**
     * Getter method which returns the date of the booking
     */
    public String getBookDate() {
        return bookDate;
    }
    
    /**
     * Getter method which returns the time of the booking
     */
    public String getBookTime() {
        return bookTime;
    }

    /**
     * Getter method which returns the current status of the booking
     */
    public bookingStatus getBookStatus() {
        return bookStatus;
    }

    /**
     * Getter method which returns the SMS pin for the booking
     */
    public String getSmsPin() {
        return smsPin;
    }

    /**
     * Getter method which returns true or false based on whether the booking is for a home test or not
     */
    public boolean isHomeTest() {
        return homeTest;
    }
    
    /**
     * Getter method which returns the user involved for the booking
     */
    public User getPatient() {
        return patient;
    }

    /**
     * Getter method which returns the testing site for the booking
     */
    public testingSite getBookSite() {
        return bookSite;
    }

    /**
     * Getter method which returns the variable that represents the caretaker class
     */
    public bookingCaretaker getBookingCaretaker() {
        return bookingCaretaker;
    }
}
