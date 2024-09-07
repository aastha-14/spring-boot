package com.aastha.firstApp.common;

// Step 2 - create class that implements the interface

import com.aastha.firstApp.Coach;
import org.springframework.stereotype.Component;

@Component // marks class as Spring Bean and makes it available for dependency injection
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In class " + getClass().getSimpleName());
    }
    // it is mandatory to override all items defined in interface
    @Override
    public String getDailyWorkout(){
        return "Practice cricket for 20 minutes";
    }
}
