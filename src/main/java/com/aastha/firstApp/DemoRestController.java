package com.aastha.firstApp;

// Step 3: create RestController

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
//    3.1 Define a private field for dependency
    private Coach myCoach;
//    3.2 define a constructor for dependency injection using @Autowired
    @Autowired
    public DemoRestController(Coach theCoach){
        System.out.println("In class " + getClass().getSimpleName());
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
