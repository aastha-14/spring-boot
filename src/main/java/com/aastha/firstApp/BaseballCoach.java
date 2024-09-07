package com.aastha.firstApp;

import org.springframework.stereotype.Component;

// marks component as spring bean and makes it available for dependency injection
@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice Baseball daily!";
    }

}
