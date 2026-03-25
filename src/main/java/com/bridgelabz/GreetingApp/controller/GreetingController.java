package com.bridgelabz.GreetingApp.controller;

import com.bridgelabz.GreetingApp.dto.GreetingDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    //UC1 - GET
    @GetMapping
    public GreetingDTO getGreeting(){
        return new GreetingDTO("Hello World - GET");
    }
    //UC1 - POST
    @PostMapping
    public GreetingDTO postGreeting(){
        return new GreetingDTO("Hello World - POST");
    }
    //UC1 - PUT
    @PutMapping
    public GreetingDTO putGreeting(){
        return new GreetingDTO("Hello World - PUT");
    }
    @DeleteMapping
    public GreetingDTO deleteGreeting(){
        return new GreetingDTO("Hello World - DELETE");
    }

}
