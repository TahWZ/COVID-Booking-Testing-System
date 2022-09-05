/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Class which is responsible for sending requests to the API to retrieve and update user data
 */
public class userAPI {
    
    /**
     * Performs GET request to fetch Users from the database.
     */
    public static ObjectNode[] getUsers(){
        ObjectNode[] data;
        try {
            HttpResponse<String> response;
            String testingSiteUrl = "https://fit3077.com/api/v2/user";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                .newBuilder(URI.create(testingSiteUrl)) // Return a JWT so we can use it in Part 5 later.
                .setHeader("Authorization", System.getenv("API_Key"))
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .GET()
                .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("\n----");
            System.out.println(request.uri());
            System.out.println("Response code: " + response.statusCode());
            System.out.println("Full JSON response: " + response.body()); // The JWT token that has just been issued will be returned since we set ?jwt=true.
            System.out.println("----\n\n");
            data = new ObjectMapper().readValue(response.body(), ObjectNode[].class);
            return data;
        } catch (Exception e){
            System.out.println("Failed to get bookings.");
            return null;
        }
    }
    
    /**
     * Posts a username and password to have it validated by the API.
     */
    public static Boolean login(String jsonString) throws Exception{
        HttpResponse<String> response;
        String usersLoginUrl = "https://fit3077.com/api/v2/user/login";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(usersLoginUrl + "?jwt=true")) // Return a JWT so we can use it in Part 5 later.
            .setHeader("Authorization", System.getenv("API_Key"))
            .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
            .POST(HttpRequest.BodyPublishers.ofString(jsonString))
            .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("\n----");
        System.out.println(request.uri());
        System.out.println("Response code: " + response.statusCode());
        System.out.println("Full JSON response: " + response.body()); // The JWT token that has just been issued will be returned since we set ?jwt=true.
        System.out.println("----\n\n");
        if (response.statusCode() == 200) {
            return true;
        } else{
            return false;
        }
    }

}
