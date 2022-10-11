package org.launchcode.spaday.controllers;

import jdk.jfr.Event;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

//    @GetMapping("/add") //http://localhost:8080/user/add
//    public String displayAddUserForm(Model model) {
//
//        model.addAttribute(new User());
//        return "user/add";
//    }
        @GetMapping("/add")
        public String getAddUserForm(Model model) {
            model.addAttribute(new User());
            return "user/add";
        }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @Valid Event newEvent, Errors errors, String verify) {

//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//        model.addAttribute("user",new User());

        if (errors.hasErrors()||user.getPassword().equals(verify)){
            return "user/add";
        } else {
//            model.addAttribute("errors", "Password doesn't match!");
//            model.addAttribute("Username",user.getUserName());
//            model.addAttribute("Email",user.getEmail());
            return "user/index";
        }
    }

}