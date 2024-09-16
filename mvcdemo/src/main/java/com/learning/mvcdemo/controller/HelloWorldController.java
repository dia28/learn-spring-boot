package com.learning.mvcdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    // show initial HTML
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process the HTML
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

//    @RequestMapping("/processFormVersionTwo")
//    public String letsShoutDude(HttpServletRequest request, Model model) {
//        String theName = request.getParameter("studentName");
//
//        theName = theName.toUpperCase();
//        String result = "Yo! " + theName;
//
//        model.addAttribute("message", result);
//        return "helloworld";
//    }

//    @RequestMapping(
//            path="/processFormVersionThree",
//            method = RequestMethod.GET) // or use directly @GetMapping
   @PostMapping("/processFormVersionThree")
    public String letsShoutDude(
            @RequestParam(name = "studentName") String theName,
            Model model) {

        theName = theName.toUpperCase();
        String result = "Yo! Hello, " + theName + "!";

        model.addAttribute("message", result);
        return "helloworld";
    }
}
