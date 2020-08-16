package edu.miu.cs.cs425.webapp.homib_tcms.controller;
import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.module.User;
import edu.miu.cs.cs425.webapp.homib_tcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/driver/list")
    public ModelAndView listDriver(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.fetchAllDrivers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("userCount", users.size());
        modelAndView.setViewName("admin/driver/list");
        return modelAndView;
    }
    @GetMapping(value = "/driver/new")
    public String displayAddNewLoadForm(Model model){
        model.addAttribute("user", new User());
        return "admin/driver/new";
    }
    @PostMapping(value = {"/tcms/driver/new","/driver/new"})
    public String addNewLoad(@Valid @ModelAttribute("user" )User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {//to show the error message for the user
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/driver/new";
        }
        user = userService.saveDrivers(user);
        return "redirect:/driver/list";
    }
///tcms/driver/edit/{userId}
    @GetMapping(value = {"/tcms/driver/edit/{userId}","/driver/edit/{userId}"})
    public String editDriver(@PathVariable Long userId, Model model){
        User user = userService.getDriverById(userId);
        if(user!= null){
            model.addAttribute("user", user);
            return "admin/driver/new";
        }
        return "admin/driver/list";
    }
    @PostMapping(value = {"tcms/driver/edit","driver/edit"})
    public String updateDriver(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/admin/driver/edit";
        }
        user = userService.saveDrivers(user);
        return "redirect:/driver/list";
    }
    @GetMapping(value = {"/tcms/driver/delete/{userId}", "driver/delete"})
    public String deleteDriver(@PathVariable Long userId, Model model){
        userService.deleteDriverById(userId);
        return "redirect:/driver/list";
    }
}
