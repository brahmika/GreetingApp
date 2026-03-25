package com.bridgelabz.GreetingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "greetings")
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String message;

    // Default Constructor - required by JPA
    public GreetingEntity() {}

    // Constructor with message only
    public GreetingEntity(String message) {
        this.message = message;
    }

    // Constructor with all fields
    public GreetingEntity(String firstName, String lastName,
                          String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.message = message;
    }

    // Getters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMessage() { return message; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
