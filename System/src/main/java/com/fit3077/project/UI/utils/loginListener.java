/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fit3077.project.UI.utils;

import com.fit3077.project.models.user.User;

/**
 * Subscriber's interface for the loginManager observer class
 * @author User
 */

public interface loginListener {
    /**
     * Creates new form searchScreen
     */
    public void updateUser(User newUser);
}
