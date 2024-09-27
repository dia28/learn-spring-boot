package com.learning.spring.security.controller;

import com.learning.spring.security.entity.User;
import com.learning.spring.security.service.UserService;
import com.learning.spring.security.user.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model model) {
        System.out.println("show registration form");
        model.addAttribute("webUser", new WebUser());
        return "register/registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("webUser") WebUser webUser,
                                          BindingResult bindingResult,
                                          HttpSession session,
                                          Model model) {
        String userName = webUser.getUserName();
        System.out.println("Processing registration form for user name: " + userName);
        if (bindingResult.hasErrors()) {
            return "register/registration-form";
        }

        User existingUser = userService.findByUserName(userName);
        if (existingUser != null) {
            model.addAttribute("webUser", new WebUser());
            model.addAttribute("registrationError", "Username already exists");
            logger.warning("Username already exists");
            return "register/registration-form";
        }

        userService.save(webUser);

        logger.info("Successfully created user: " + userName);
        session.setAttribute("user", webUser);
        return "registration-confirmation";
    }
}
