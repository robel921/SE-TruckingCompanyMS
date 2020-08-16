package edu.miu.cs.cs425.webapp.homib_tcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogInController {

    @GetMapping(value = {"/user/login/","/secured/home/login/"})
    public String displayLogInPage(){
        return "secured/home/login";
    }

    @GetMapping(value = {"/login", "/login/home"})
    public String displayHomePage(){
        return "secured/home/login";
    }

    @GetMapping(value = "/login/about/page")
    public String displayAboutPage(){
        return "public/home/loginabout";
    }

    @GetMapping(value = "/login/contact/page")
    public String displayContactPage(){
        return "public/home/logincontact";
    }

    @PostMapping(value = "/admin")
public String displayErrorPage(){
        return "redirect:/user/login/";
}

}
