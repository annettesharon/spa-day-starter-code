package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add") //http://localhost:8080/user/add
    public String displayAddUserForm(Model model) {

        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {


//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);

        if (!(user.getPassword().isBlank()) && !(verify.isBlank()) && verify.equals(user.getPassword())) {
            return "user/index";
        } else {
            model.addAttribute("errors", "Password doesn't match!");
            model.addAttribute("Username",user.getUserName());
            model.addAttribute("Email",user.getEmail());
            return "user/add";
        }
    }

}