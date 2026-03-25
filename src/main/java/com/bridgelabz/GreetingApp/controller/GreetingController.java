package com.bridgelabz.GreetingApp.controller;

import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import com.bridgelabz.GreetingApp.model.GreetingEntity;
import com.bridgelabz.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // UC1/UC2 - Simple GET
    @GetMapping
    public GreetingDTO getGreeting() {
        return new GreetingDTO(greetingService.getGreetingMessage());
    }

    // UC3 - POST with optional firstName and lastName
    @PostMapping
    public GreetingDTO postGreeting(@RequestBody GreetingEntity user) {
        return new GreetingDTO(greetingService.getGreetingMessage(user));
    }

    // UC1 - PUT
    @PutMapping
    public GreetingDTO putGreeting() {
        return new GreetingDTO(greetingService.getGreetingMessage());
    }

    // UC1 - DELETE
    @DeleteMapping
    public GreetingDTO deleteGreeting() {
        return new GreetingDTO(greetingService.getGreetingMessage());
    }
}
