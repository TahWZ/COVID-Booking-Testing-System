/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fit3077.project.models.testingSite;

/**
 * An interface for the testingSiteAPICollection class to extend from
 */
public interface testingSiteCollection {
    /**
     * Get all TestSites
     */
    public testingSite[] getTestingSites();
    
    /**
     * Get TestSite through localID (The ID provided by the local system)
     */
    public testingSite getTestingSiteByLocalID(int localID);
    
    /**
     * Get TestSite through ID (ID provided by the Web Service)
     */
    public testingSite getTestingSiteByID(String ID);
}
