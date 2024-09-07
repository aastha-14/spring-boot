package com.aastha.firstApp.config;

import com.aastha.firstApp.Coach;
import com.aastha.firstApp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Step 1 : mark class as @Configuration to add configurations
// Step 2 : create a method and mark it as bean annotation
@Configuration
public class SportConfig {
//    by default it should be swimCoach
//    we can change by providing in @Bean("aquatic")
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
