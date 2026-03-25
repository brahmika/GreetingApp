package com.bridgelabz.GreetingApp.repository;

import com.bridgelabz.GreetingApp.model.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository
        extends JpaRepository<GreetingEntity, Long> {

}