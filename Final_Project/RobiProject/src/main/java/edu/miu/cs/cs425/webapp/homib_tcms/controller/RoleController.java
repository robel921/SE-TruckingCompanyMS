package edu.miu.cs.cs425.webapp.homib_tcms.controller;
import edu.miu.cs.cs425.webapp.homib_tcms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

}
