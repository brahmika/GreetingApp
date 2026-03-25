package com.bridgelabz.GreetingApp.service;

import com.bridgelabz.GreetingApp.model.GreetingEntity;
import com.bridgelabz.GreetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // UC2 - Simple greeting
    public String getGreetingMessage() {
        return "Hello World";
    }

    // UC3 - Smart greeting based on names
    public String getGreetingMessage(GreetingEntity user) {
        if (user.getFirstName() != null && !user.getFirstName().isEmpty()
                && user.getLastName() != null
                && !user.getLastName().isEmpty()) {
            return "Hello " + user.getFirstName()
                    + " " + user.getLastName();
        }
        if (user.getFirstName() != null
                && !user.getFirstName().isEmpty()) {
            return "Hello " + user.getFirstName();
        }
        if (user.getLastName() != null
                && !user.getLastName().isEmpty()) {
            return "Hello " + user.getLastName();
        }
        return "Hello World";
    }

    // UC4 - Save greeting to database
    public GreetingEntity saveGreeting(GreetingEntity user) {
        String message = getGreetingMessage(user);
        GreetingEntity greeting = new GreetingEntity(
                user.getFirstName(),
                user.getLastName(),
                message
        );
        return greetingRepository.save(greeting);
    }

    // UC5 - Find greeting by ID
    public GreetingEntity findGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Greeting not found with id: " + id));
    }

    // UC6 - Get all greetings
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC7 - Edit greeting by ID
    public GreetingEntity updateGreeting(Long id,
                                         GreetingEntity user) {
        GreetingEntity existing = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Greeting not found with id: " + id));

        // Update the fields
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setMessage(getGreetingMessage(user));

        return greetingRepository.save(existing);
    }
    // UC8 - Delete greeting by ID
    public String deleteGreeting(Long id) {
        GreetingEntity existing = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Greeting not found with id: " + id));
        greetingRepository.deleteById(id);
        return "Greeting with id: " + id + " deleted successfully!";
    }
}