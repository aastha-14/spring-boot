package com.aastha.firstApp.common;

import com.aastha.firstApp.Coach;

public class SwimCoach implements Coach {
    public SwimCoach(){
        System.out.println("In class " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim for 10 miles.";
    }
}
