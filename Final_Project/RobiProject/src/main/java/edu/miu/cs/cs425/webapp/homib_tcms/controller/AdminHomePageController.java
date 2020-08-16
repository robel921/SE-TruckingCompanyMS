package edu.miu.cs.cs425.webapp.homib_tcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomePageController {


    @GetMapping(value = {"/admin", "/admin/home"})
     public String displayHomePage(){
         return "secured/home/admin";
     }

    @GetMapping(value = "admin/about")
    public String displayAboutPage(){
        return "secured/home/about";
    }

    @GetMapping(value = "admin/contact")
    public String displayContactPage(){
        return "secured/home/contact";
    }

}
