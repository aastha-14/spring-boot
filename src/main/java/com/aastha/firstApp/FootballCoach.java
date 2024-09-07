package com.aastha.firstApp;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play Football with friends!";
    }
}
