/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.booking;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.testingSite.testingSiteAPICollection;
import com.fit3077.project.models.testingSite.testingSiteCollection;
import com.fit3077.project.models.user.userAPICollection;
import com.fit3077.project.models.user.userCollection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * The class which is responsible for storing the booking objects and providing methods to retrieve them.
 */
public class bookingAPICollection implements bookingCollection {
    
    private static bookingAPICollection bCollection = null;
    private Booking[] bookings;
    //The most recently changed booking
    private Booking recentBooking;
    //The previous testing site for the most recently changed booking
    private String recentBookingPrevTSID = "";
    
    /**
     * Constructor method for the bookingAPICollection class
     */
    private bookingAPICollection(){
        convertToBooking(bookingAPI.getBookings());
    }
    
    /**
     * Method which retrieves the single instance of the class, or instantiates it if it is still null
     */
    public static bookingAPICollection getInstance(){
        if (bCollection == null){
            bCollection = new bookingAPICollection();
        }
        return bCollection;
    }
    
    /**
     * Parses the JSON object retrieved from the booking database, and converts it to booking objects 
     */
    private void convertToBooking(ObjectNode[] data){
        userCollection uCollection = userAPICollection.getInstance();
        testingSiteCollection tsCollection = testingSiteAPICollection.getInstance();
        int count = data.length;
        bookings = new Booking[count];
        for (int i=0;i < count;i++){
            bookings[i] = bookingFactory.createBooking(
                    data[i].get("id").textValue(),
                    uCollection.getUserByUserID(data[i].get("customer").get("id").asText()),
                    tsCollection.getTestingSiteByID(data[i].get("testingSite").get("id").asText()),
                    data[i].get("startTime").textValue(),
                    initiateBookDate(data[i].get("startTime").textValue().substring(0,23)),
                    initiateBookTime(data[i].get("startTime").textValue().substring(0,23)),
                    data[i].get("notes").textValue(),
                    bookingStatus.valueOf(data[i].get("status").textValue()),
                    data[i].get("smsPin").textValue(),
                    data[i].get("additionalInfo")
            );
        }
    }
    
    /**
     * Method which returns a booking through its QR code
     */
    @Override
    public Booking getBookingByQR(String QRcode){
        for (Booking b :bookings){
            if (b.getQRcode() != null && b.getQRcode().equals(QRcode)){
                return b;
            }
        }
        return null;
    }
    
    /**
     * Method which returns a booking through its QR code
     */
    @Override
    public Booking[] getBookingsByUsername(String username){
        Booking[] result;
        int count = 0;
        for (Booking b :bookings){
            if (b.getPatient().getUsername().equals(username)){
                count += 1;
            }
        }
        if (count != 0){
            result = new Booking[count];
            int i = 0;
            for (Booking b :bookings){
                if (b.getPatient().getUsername().equals(username)){
                    result[i] = b;
                    i++;
                }
            }
            return result;
        } else{
            return null;
        }
    }
    
    /**
     * Method which returns the total waiting time for a given testing site
     */
    @Override
    public int getWaitingTime(testingSite site, String date){
        try {
            int bookCount = 0;
            Booking[] filteredBookings = new Booking[bookings.length];
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date specifiedDate = dateFormatter2.parse(date);
            for (int i=0;i < bookings.length;i++) {
                Date checkDate = dateFormatter.parse(bookings[i].getBookDate());
                if (specifiedDate.equals(checkDate) && bookings[i].getBookSite().getID().equals(site.getID())){
                    filteredBookings[i] = bookings[i];
                    bookCount += 1;
                }
            } 
            return bookCount * 20;
        }
        catch (ParseException e) {
            System.out.println("Parsing error found whilst filtering bookings");
            return 0;
        }
    }
    
    /**
     * Method which returns a booking through its PIN code
     */
    @Override
    public Booking getBookingByPIN(String PINcode){
        for (Booking b :bookings){
            if (b.getSmsPin().equals(PINcode)){
                return b;
            }
        }
        return null;
    }
    
    /**
     * Method which returns a booking through its ID
     */
    @Override
    public Booking getBookingByID(String ID){
        for (Booking b :bookings){
            if (b.getID().equals(ID)){
                return b;
            }
        }
        return null;
    }
    
    /**
     * Method which parses a date and time string to retrieve its time component
     */
    public String initiateBookTime(String bookDate)
    {
       try {
            SimpleDateFormat dF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH); 
            Date date = dF.parse(bookDate);
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm"); 
            return timeFormatter.format(date);
       }
       catch (ParseException e) {
            return "Parsing error";
       }
    }
    
    /**
     * Method which parses a date and time string to retrieve its date component
     */
    public String initiateBookDate(String bookDate)
    {
       try {
            SimpleDateFormat dF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH); 
            Date date = dF.parse(bookDate);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy"); 
            return dateFormatter.format(date);
       }
       catch (ParseException e) {
            return "Parsing error";
       }
    }
    
    /**
     * Getter method which retrieves the list of bookings
     */
    public Booking[] getAllBookings(){
        return bookings;
    }
    
    /**
     * Refreshes bookings whenever a booking is modified, added or deleted
     */
    public bookingNotification reloadBookings(){
        ObjectNode[] serverData = bookingAPI.getBookings(); //The current data from the server
        int sdCount = serverData.length; //The number of bookings stored in the server
        Booking localBooking;
        //Case when a booking is deleted
        if (bookings.length > sdCount){
            Boolean found;
            for (int i=0; i < bookings.length; i++){
                found = false;
                localBooking = bookings[i];
                //Searches for the booking that was deleted
                for (int j=0; j < sdCount; j++){
                    if (localBooking.getID().equals(serverData[j].get("id").textValue())){
                        found = true;
                    }
                }
                if (!found){
                    //Stores the recently changed booking temporarily
                    recentBooking = localBooking;
                    //Updates locally stored bookings
                    convertToBooking(serverData);
                    return bookingNotification.DELETED;
                }
            }
        //Case when a new booking was added    
        } else if (bookings.length < sdCount){
            //Identifies the added booking
            for (int i=0; i < sdCount; i++){
                localBooking = getBookingByID(serverData[i].get("id").textValue());
                if (localBooking == null){
                    String localBookingID = serverData[i].get("id").textValue();
                    //Updates locally stored bookings
                    convertToBooking(serverData);
                    //Stores the recently changed booking temporarily
                    recentBooking = getBookingByID(localBookingID);
                    return bookingNotification.NEW;
                }
            }
        }
        //Case where a booking may had been potentially modified or cancelled 
        for (int i=0;i < sdCount;i++){
            //Search for modified booking
            if (serverData[i].get("additionalInfo").get("lastModifiedTime") != null){
                String serverLastModified = serverData[i].get("additionalInfo").get("lastModifiedTime").textValue();
                localBooking = getBookingByID(serverData[i].get("id").textValue());
                //If a modified booking was found
                if (!serverLastModified.equals(localBooking.getLastModTime())){
                    String localBookingID = localBooking.getID();
                    bookingStatus localStatus = localBooking.getBookStatus();
                    //Updates locally stored bookings
                    convertToBooking(serverData);
                    //Stores the recently changed booking temporarily
                    recentBooking = getBookingByID(localBookingID);
                    //Check if its a booking cancellation or modification
                    if (recentBooking.getBookStatus() == bookingStatus.CANCELLED && localStatus != bookingStatus.CANCELLED){
                        return bookingNotification.CANCELLED;
                    } else{
                        recentBookingPrevTSID = localBooking.getBookSite().getID();
                        return bookingNotification.MODIFIED;
                    }
                }
            }
        }
        return bookingNotification.NONE;
    }

    /**
     * Getter method which returns the booking which was previously modified, added or deleted
     */
    public Booking getRecentBooking() {
        return recentBooking;
    }

    /**
     * Getter method which returns the testing site ID of the booking before it was modified
     */
    public String getPreviousBookingSiteID() {
        return recentBookingPrevTSID;
    }
    
    
}
