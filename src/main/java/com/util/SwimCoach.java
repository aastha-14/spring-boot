package com.util;

import com.aastha.firstApp.Coach;

public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Swim for 10 miles.";
    }
}
