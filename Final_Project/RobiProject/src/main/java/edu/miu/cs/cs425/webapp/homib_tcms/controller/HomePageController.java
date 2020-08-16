package edu.miu.cs.cs425.webapp.homib_tcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/", "/home"})
    public String displayHomePage(){
        return "public/home/index";
    }


}
