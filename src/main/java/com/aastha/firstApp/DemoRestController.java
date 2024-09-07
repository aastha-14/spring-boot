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
    private Coach cricketCoach;
//    3.2 define a constructor for dependency injection using @Autowired
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach anotherCoach){
        System.out.println("In class " + getClass().getSimpleName());
        myCoach = theCoach;
        cricketCoach = anotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check-scope")
    public String getFootballWorkout(){
//        returns true when scope is Singleton - as this creates single instance in the entire lifecycle
//        returns false if prototype - as this creates instance each time
        return "Check if myCoach == cricketCoach " + (myCoach == cricketCoach);
    }
}
