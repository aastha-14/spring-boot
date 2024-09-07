package com.aastha.firstApp;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Lazy
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
