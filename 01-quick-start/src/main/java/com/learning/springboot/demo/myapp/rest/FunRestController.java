package com.learning.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamName() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run at least 5km!";
    }

    /*
        mvnw spring-boot:run

        OR

        java -jar target\myapp-0.0.1-SNAPSHOT.jar
     */
}
