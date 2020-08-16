package edu.miu.cs.cs425.webapp.homib_tcms.controller;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DriverHomePageController {

    @Autowired
    private LoadService loadService;

    @GetMapping(value = {"/driver", "/driver/home"})
    public String displayHomePage(){
        return "secured/driver/main";
    }

    @GetMapping(value = "/driver/about/page")
    public String displayAboutPage(){
        return "public/home/about";
    }

    @GetMapping(value = "/driver/contact/page")
    public String displayContactPage(){
        return "public/home/contact";
    }


    @GetMapping(value = {"/driver/load/list"})
    public ModelAndView listLoads(){
        ModelAndView modelAndView = new ModelAndView();
        List<Load> loads = loadService.fetchAllLoads();
        modelAndView.addObject("loads", loads);
        modelAndView.addObject("loadsCount", loads.size());
        modelAndView.setViewName("driver/drivers/list");
        return modelAndView;
    }

    @GetMapping(value = "/booked/success")
    public String showSuccessPage(){
        return "secured/driver/success";
    }

}

