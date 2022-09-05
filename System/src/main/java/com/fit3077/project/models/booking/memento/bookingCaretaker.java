/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.booking.memento;

import java.util.ArrayList;

/**
 * Class which represents the caretaker component of the Memento design pattern
 */
public class bookingCaretaker {
    //private final Map<String, bookingMemento>lastModifiedPoint = new HashMap<String, bookingMemento>();
    private final int capacity = 3;
    private ArrayList<bookingMemento> savePoints = new ArrayList<bookingMemento>(3);
    
    
    /**
     * Saves a memento in the savePoints array list
     */   
    public void saveMemento(bookingMemento bm){
        if (savePoints.isEmpty()){
            savePoints.add(bm);
        } else if (savePoints.size() < capacity){
            savePoints.add(bm);
        } else{
            for (int i=0; i< capacity-1; i++){
                savePoints.set(i, savePoints.get(i+1));
            }
            savePoints.set(capacity-1, bm);
        }
    }
    
    /**
     * Deletes a save point based on its index
     */   
    public void deleteSavepoint(int index){
        for (int i = 0; i < capacity-1; i++){
            if (index + 1 <= capacity-1){                
                savePoints.set(i, savePoints.get(index+1));
            } else {
                savePoints.set(i,null);
            }
        }  
    }
    
    /**
     * Retrieves a booking memento based on its index
     */   
    public bookingMemento getMemento(int savePoint){
        if (savePoint >= capacity || savePoint >= savePoints.size()){
            return null;
        }
        return savePoints.get(savePoint);
    }
    
    /**
     * Clears all save points in the savePoint array list
     */   
    public void clearSavepoints(int remain){
        for (int i=capacity-1; i>= remain; i--){
            savePoints.remove(i);
        }
    }

    /**
     * Getter method which returns the maximum capacity of the savePoint array list
     */   
    public int getCapacity() {
        return capacity;
    }

    /**
     * Getter method which returns the savePoint array list
     */  
    public ArrayList<bookingMemento> getSavePoints() {
        return savePoints;
    }
    
    /**
     * Method which returns the appropriate JSON string for the mementos
     */ 
    public String getMementosJSON(){
        String mementosJSON = "";
        String savePoint;
        for (int i = 0; i < getCapacity(); i++) {
            if (i < savePoints.size() && getMemento(i) != null){                        
                savePoint = "{" +
                "\"bookingID\":\"" + getMemento(i).getBookingID() + "\"," +
                "\"status\":\"" + getMemento(i).getStatus().toString() + "\"," +
                "\"startTime\":\"" + getMemento(i).getStartTime() + "\"," +        
                "\"testSite\":\"" + getMemento(i).getTestingSiteID() + "\"," +
                "\"lastModifiedTime\":\"" + getMemento(i).getLastModificationTime() + "\"" +
                "}";
            } else{
                savePoint = "\"none\"";
            }                   
            mementosJSON += "\"savePoint" + String.valueOf(i+1) + "\":" + savePoint;
            if (i == getCapacity() - 1){
                mementosJSON += "";
            } else {
                mementosJSON += ",";
            }
        }
        return mementosJSON;
    }
    
}
