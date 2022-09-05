/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Class which is responsible for sending requests to the API to retrieve and update COVID test data
 */
public class testingAPI {
    
    /**
     * Performs POST request to insert a COVID test entry into the database.
     */
    public static Boolean postTesting(String jsonString){
            try {
                HttpResponse<String> response;

            
                // Note the POST() method being used here, and the request body is supplied to it.
                // A request body needs to be supplied to this endpoint, otherwise a 400 Bad Request error will be returned.
                String bookingURL = "https://fit3077.com/api/v2/covid-test";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(URI.create(bookingURL)) // Return a JWT so we can use it in Part 5 later.
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
                if (response.statusCode() == 201) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                return false;
            }  
    }
}
