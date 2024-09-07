package com.aastha.firstApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
// marks component as spring bean and makes it available for dependency injection
@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Practice Baseball daily!";
    }

}
