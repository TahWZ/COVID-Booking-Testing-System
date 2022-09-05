/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fit3077.project.models.testingSite;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author User
 */
public class testingSiteAPI {
    
    /**
     * Performs GET request to fetch testingSite resource.
     */
    public static ObjectNode[] getTestingSites(){
        HttpResponse<String> response;
            String testingSiteUrl = "https://fit3077.com/api/v2/testing-site";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                .newBuilder(URI.create(testingSiteUrl)) // Return a JWT so we can use it in Part 5 later.
                .setHeader("Authorization", System.getenv("API_Key"))
                .header("Content-Type","application/json") // This header needs to be set when sending a JSON request body.
                .GET()
                .build();

            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("\n----");
                System.out.println(request.uri());
                System.out.println("Response code: " + response.statusCode());
                System.out.println("Full JSON response: " + response.body()); // The JWT token that has just been issued will be returned since we set ?jwt=true.
                System.out.println("----\n\n");
                if (response.statusCode() == 200) {
                    return new ObjectMapper().readValue(response.body(), ObjectNode[].class);
                }
            } catch (Exception e){}
            return null;
    }
}
