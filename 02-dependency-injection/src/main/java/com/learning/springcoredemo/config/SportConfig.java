package com.learning.springcoredemo.config;

import com.learning.springcoredemo.common.Coach;
import com.learning.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // can be used instead of @Component
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
