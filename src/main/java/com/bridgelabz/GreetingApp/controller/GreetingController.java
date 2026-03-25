package com.bridgelabz.GreetingApp.controller;

import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import com.bridgelabz.GreetingApp.model.GreetingEntity;
import com.bridgelabz.GreetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

    // UC4 - POST saves greeting to database
    @PostMapping
    public GreetingEntity postGreeting(
            @RequestBody GreetingEntity user) {
        return greetingService.saveGreeting(user);
    }

    // UC5 - GET greeting by ID
    @GetMapping("/{id}")
    public GreetingEntity getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    // UC6 - GET all greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // UC7 - PUT update greeting by ID
    @PutMapping("/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id,
                                         @RequestBody GreetingEntity user) {
        return greetingService.updateGreeting(id, user);
    }

    // UC1 - DELETE
    @DeleteMapping
    public GreetingDTO deleteGreeting() {
        return new GreetingDTO(greetingService.getGreetingMessage());
    }
}
