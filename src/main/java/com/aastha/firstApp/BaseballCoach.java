package com.aastha.firstApp;

import org.springframework.stereotype.Component;

// marks component as spring bean and makes it available for dependency injection
@Component
public class BaseballCoach implements Coach {
    public BaseballCoach(){
        System.out.println("In class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice Baseball daily!";
    }

}
