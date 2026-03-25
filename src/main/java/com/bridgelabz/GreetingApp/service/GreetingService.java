package com.bridgelabz.GreetingApp.service;

import com.bridgelabz.GreetingApp.model.GreetingEntity;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // UC2 - Simple greeting
    public String getGreetingMessage() {
        return "Hello World";
    }

    // UC3 - Smart greeting based on names provided
    public String getGreetingMessage(GreetingEntity user) {

        // Both firstName and lastName provided
        if (user.getFirstName() != null && !user.getFirstName().isEmpty()
                && user.getLastName() != null && !user.getLastName().isEmpty()) {
            return "Hello " + user.getFirstName()
                    + " " + user.getLastName();
        }

        // Only firstName provided
        if (user.getFirstName() != null && !user.getFirstName().isEmpty()) {
            return "Hello " + user.getFirstName();
        }

        // Only lastName provided
        if (user.getLastName() != null && !user.getLastName().isEmpty()) {
            return "Hello " + user.getLastName();
        }

        // No names provided
        return "Hello World";
    }
}