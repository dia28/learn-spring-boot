package com.learning.mvcdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    // show initial HTML
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process the HTML
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        String result = "Yo! " + theName;

        model.addAttribute("message", result);
        return "helloworld";
    }
}
