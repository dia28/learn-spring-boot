package com.learning.springcoredemo.rest;

import com.learning.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
//    private Coach anotherCoach;

    // constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

//    @Autowired
//    public DemoController(
//            @Qualifier("cricketCoach") Coach theCoach,
//            @Qualifier("cricketCoach") Coach theAnotherCoach) {
//        System.out.println("In constructor: " + getClass().getSimpleName());
//        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
//    }

    // No need to use qualifier if u use @Primary in one of the component classes
    // Qualifier has priority
//    @Autowired
//    public void setMyCoach(@Qualifier("cricketCoach") Coach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
//    }
}
