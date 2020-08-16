package edu.miu.cs.cs425.webapp.homib_tcms.controller;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Booking;
import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.module.User;
import edu.miu.cs.cs425.webapp.homib_tcms.service.BookingService;
import edu.miu.cs.cs425.webapp.homib_tcms.service.LoadService;
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
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private LoadService loadService;

    @Autowired
    private UserService userService;


    @GetMapping(value = {"/admin/booking/list", "/booking/list"} )
    public ModelAndView listLoad(){

        ModelAndView modelAndView = new ModelAndView();
        List<Booking> bookings = bookingService.fetchAllBookings();
        List<Load> loads = loadService.fetchAllLoads();
        //modelAndView.addObject("loads",loads );
        modelAndView.addObject("book", bookings);
        modelAndView.addObject("bookingCount", bookings.size());
        modelAndView.setViewName("admin/booking/list");//TODO
        return modelAndView;
    }
    @GetMapping(value = "/booking/new")
    public String displayAddNewBookingForm(Model model){
//        int loadId=0;
//        int userId= 0;
        List<User> users = userService.fetchAllDrivers();
        List<Load> loads = loadService.fetchAllLoads();
        model.addAttribute("loads",loads );
//        model.addAttribute("loadId",loadId);
        model.addAttribute("users",users );
//        model.addAttribute("userId",userId);
        model.addAttribute("booking", new Booking());

        return "/admin/booking/new";//ToDO
    }
    @PostMapping(value = {"/tcms/booking/saved","/booking/saved"})
    public String addNewBooking(@Valid @ModelAttribute("booking" )Booking booking, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {//to show the error message for the user
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/admin/booking/new";
        }
       //booking.setLoad();
        System.out.println(booking.toString());
         bookingService.saveBooking(booking);
        return "redirect:/booking/list";
    }
    @GetMapping(value = {"/tcms/booking/edit/{bookingId}","/booking/edit/{bookingId}"})
    public String editBooking(@PathVariable Long bookingId, Model model){
        List<Booking> booking = bookingService.fetchAllBookings();
        if(booking!= null){
            model.addAttribute("bookings",booking);
            return "/admin/booking/edit";//TODO
        }
        return "/admin/booking/list";
    }
    @PostMapping(value = {"tcms/booking/edit","booking/edit"})
    public String updateBooking(@Valid @ModelAttribute("booking") Booking booking,
                             BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/admin/booking/edit";
        }
        booking = bookingService.saveBooking(booking);
        return "redirect:/booking/list";
    }

    @GetMapping(value = {"/tcms/booking/delete/{bookingId}", "booking/delete"})
    public String deleteBook(@PathVariable Long bookingId, Model model){
        System.out.println(bookingId);
        bookingService.deleteBookingById((long) 1);
        return "redirect:/booking/list";
    }



}
