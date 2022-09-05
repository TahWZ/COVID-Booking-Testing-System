/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fit3077.project.models.booking.memento;

/**
 * Originator interface class for classes that utilizes the memento saved states
 * @author User
 */
public interface bookingOriginator {
    
    
    /**
     * Creates a booking memento (save point) in the caretaker component of the memento design pattern
     */
    public void createSavepoint(String currentTime);
    
    /**
     * Restores a save point from the SavePoint array
     */
    public void undo(int savePoint);
    
    /**
     * Restores data from a save point from the SavePoint array
     */
    public void setOriginatorState(int savePoint);
    
}
