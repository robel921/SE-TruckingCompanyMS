package edu.miu.cs.cs425.webapp.homib_tcms.controller;


import edu.miu.cs.cs425.webapp.homib_tcms.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

}
