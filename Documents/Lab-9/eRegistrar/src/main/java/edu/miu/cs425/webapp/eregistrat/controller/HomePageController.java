package edu.miu.cs425.webapp.eregistrat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value ={ "/", "/home", "/eregistrat/homes"})
    public String displayHomePage(){
        return "home/index";
    }
}
