package com.util;

import com.aastha.firstApp.Coach;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    public FootballCoach(){
        System.out.println("In class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Play Football with friends!";
    }
}
