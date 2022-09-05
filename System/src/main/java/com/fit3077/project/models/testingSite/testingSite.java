/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.testingSite;

import com.fasterxml.jackson.databind.JsonNode;
import java.sql.Timestamp;
import java.time.LocalTime;

/**
 *
 * @author User
 */
public class testingSite {
    private String ID, name, description, websiteUrl, phoneNumber, facilityType, suburb , postcode, openTime;
    private Boolean hasWalkIn, hasDriveThrough, onSiteBooking, onSiteTesting;
    private int localID, workDuration;
    
    /**
     * Constructor method for the testing site class
     */ 
    public testingSite(int localID, String ID, String name, String description, String websiteUrl, String phoneNumber, JsonNode address, JsonNode additions) {
        this.localID = localID;
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
        setAdditions(additions);
        setAddress(address);
    }
    
    /**
     * Set attributes from the additionalInfo field to the appropriate variables 
     */
    private void setAdditions(JsonNode additions){
        this.facilityType = additions.get("facilityType").textValue();
        this.hasWalkIn = additions.get("hasWalkIn").asBoolean();
        this.hasDriveThrough = additions.get("hasDriveThrough").asBoolean();
        this.onSiteBooking = additions.get("onSiteBooking").asBoolean();
        this.onSiteTesting = additions.get("onSiteTesting").asBoolean();
        this.openTime = additions.get("openTime").textValue();
        this.workDuration = additions.get("workDuration").asInt();
    }
    
    /**
     * Set attributes from the additionalInfo field to the appropriate variables 
     */
    private void setAddress(JsonNode address){
        this.suburb = address.get("suburb").textValue();
        this.postcode = address.get("postcode").textValue();
    }

    /**
     * Checks if the testingSite is currently open through the system's time
     */
    public Boolean getStatus(){
        LocalTime startTime = LocalTime.parse(openTime);
        LocalTime endTime = startTime.plusMinutes(workDuration);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalTime currentTime = timestamp.toLocalDateTime().toLocalTime();
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)){
            return true;
        }
        return false;
      
    }
    
    /**
     * Getter method which returns the name of the testing site
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method which returns the opening time of the testing site
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * Getter method which returns true or false based on the availability of on-site booking at this test site
     */
    public Boolean getOnSiteBooking() {
        return onSiteBooking;
    }

    /**
     * Getter method which returns true or false based on the availability of on-site testing at this test site
     */
    public Boolean getOnSiteTesting() {
        return onSiteTesting;
    }

    /**
     * Getter method which returns the description of the testing site
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method which returns the website URL of the testing site
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * Getter method which returns the phone number of the testing site
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Getter method which returns the facility type of the testing site
     */
    public String getFacilityType() {
        return facilityType;
    }

    /**
     * Getter method which returns the Suburb part of the address for this testing site
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * Getter method which returns the postcode for this testing site
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Getter method which returns the duration (in hours) of work time for this testing site
     */
    public int getWorkDuration() {
        return workDuration;
    }

    /**
     * Getter method which returns true or false based on the availability of walk-in at this testing site
     */
    public Boolean getHasWalkIn() {
        return hasWalkIn;
    }

    /**
     * Getter method which returns true or false based on the availability of drive-through at this testing site
     */
    public Boolean getHasDriveThrough() {
        return hasDriveThrough;
    }

    /**
     * Getter method which returns the ID of the testing site
     */
    public String getID() {
        return ID;
    }

    /**
     * Getter method which returns the local ID of the testing site
     */
    public int getLocalID() {
        return localID;
    }
    
}
