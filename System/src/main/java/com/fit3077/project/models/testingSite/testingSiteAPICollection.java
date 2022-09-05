/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.testingSite;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *
 * @author User
 */
public class testingSiteAPICollection implements testingSiteCollection{

    private testingSite[] testingSites; //Array of all TestingSite 
    private int count; //Number of items in testingSites
    private static testingSiteAPICollection singleton = null;
    
    /**
     * Creates new instance if first call, else returns cached instance
     */
    public static testingSiteAPICollection getInstance(){
        if (singleton == null){
            singleton = new testingSiteAPICollection();
        }
        return singleton;
    }
    
    /**
     * Constructor set to private for singleton
     */
    private testingSiteAPICollection(){
        convertToTestingSites(testingSiteAPI.getTestingSites());
    }
    
    /**
     * Converts ObjectNode[] from API to TestingSites
     */
    private void convertToTestingSites(ObjectNode[] data){
        count = data.length;
        testingSites = new testingSite[count];
        for (int i=0;i < count;i++){
            testingSites[i] = new testingSite(
                    i+1,
                    data[i].get("id").textValue(),
                    data[i].get("name").textValue(),
                    data[i].get("description").textValue(),
                    data[i].get("websiteUrl").textValue(),
                    data[i].get("phoneNumber").textValue(),
                    data[i].get("address"),
                    data[i].get("additionalInfo")
            );
        }
    }
    
    // Interface methods
    public testingSite[] getTestingSites(){
        return testingSites;
    }
    
    public testingSite getTestingSiteByLocalID(int localID){
        try {
            testingSite tsite = testingSites[localID-1];
            return tsite;
        } catch (Exception e){}
        return null;
    }
    
    public testingSite getTestingSiteByID(String ID){
        try {
            for (int i=0;i<testingSites.length;i++){
                if (testingSites[i].getID().equals(ID)){
                    return testingSites[i];
                }
            }
        } catch (Exception e){}
        return null;
    }
    
}
