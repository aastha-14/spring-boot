package com.aastha.firstApp;

// Step 2 - create class that implements the interface

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // marks class as Spring Bean and makes it available for dependency injection
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In class " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doAfterCreation(){
        System.out.println(getClass().getSimpleName() + " is created");
    }
    @PreDestroy
    public void doCleanup(){
        System.out.println(getClass().getSimpleName() + " is destroyed");
    }
    // it is mandatory to override all items defined in interface
    @Override
    public String getDailyWorkout(){
        return "Practice cricket for 20 minutes";
    }
}
