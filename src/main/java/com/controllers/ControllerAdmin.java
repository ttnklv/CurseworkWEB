package com.controllers;

import com.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.service.AdminService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdmin {

    private final AdminService adminService;

    @Autowired
    public ControllerAdmin(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    String hello() {
        if (adminService.returnLogin() != null)
            return adminService.returnLogin();
        else return "Empty request";
    }

}
