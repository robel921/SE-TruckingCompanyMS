package edu.miu.cs.cs425.webapp.homib_tcms.controller;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import org.springframework.stereotype.Controller;
import edu.miu.cs.cs425.webapp.homib_tcms.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoadController {
    @Autowired
    private LoadService loadService;

    @GetMapping(value = {"/admin/load/list", "/loads/list"} )
    public ModelAndView listLoad(){
        ModelAndView modelAndView = new ModelAndView();
        List<Load> loads = loadService.fetchAllLoads();
        modelAndView.addObject("loads", loads);
        modelAndView.addObject("loadCount", loads.size());
        modelAndView.setViewName("admin/load/list");
        return modelAndView;
    }
    @GetMapping(value = "/load/new")
    public String displayAddNewLoadForm(Model model){
        model.addAttribute("load", new Load());
        return "admin/load/new";
    }
    @PostMapping(value = {"/list/load/new"})
    public String addNewLoad(@Valid @ModelAttribute("load" )Load load, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {//to show the error message for the user
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/load/new";
        }
        load = loadService.saveLoads(load);
        return "redirect:/admin/load/list";
    }
    @GetMapping(value = {"/tcms/load/edit/{loadId}","/load/edit/{loadId}"})
    public String editLoad(@PathVariable Long loadId, Model model){
        Load load = loadService.getLoadById(loadId);
        if(load!= null){
            model.addAttribute("load",load);
            return "admin/load/edit";
        }
        return "admin/load/list";
    }
    @PostMapping(value = {"tcms/load/edit","load/edit"})
    public String updateLoad(@Valid @ModelAttribute("load") Load load,
                                BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/admin/load/edit";
        }
        load = loadService.saveLoads(load);
        return "redirect:/admin/load/list";
    }

    @GetMapping(value = {"tcms/load/delete/{loadId}", "load/delete"})
    public String deleteBook(@PathVariable Long loadId, Model model){
        loadService.deleteLoadById(loadId);
        return "redirect:/admin/load/list";
    }

}
