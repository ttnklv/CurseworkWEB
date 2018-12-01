package com.controllers;

import com.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCustomers {

    private final CustomersService customersService;

    @Autowired
    public ControllerCustomers(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/updateMail")
    String changeEmail() {
        if (customersService.updateEmail() != null)
            return customersService.updateEmail();
        else return "Empty request";
    }

    @GetMapping("/updateLevelAccess")
    String changeLevelAccess() {
        if (customersService.updateLevelAccess() != null)
            return customersService.updateLevelAccess();
        else return "Empty request";
    }

    @GetMapping("/updatePassword")
    String changePassword() {
        if (customersService.updatePassword() != null)
            return customersService.updatePassword();
        else return "Empty request";
    }

    @GetMapping("/updateMobailNumber")
    String changeMobailNumber() {
        if (customersService.updateMobailNumber() != null)
            return customersService.updateMobailNumber();
        else return "Empty request";
    }

    @GetMapping("/updateName")
    String changeName() {
        if (customersService.updateName() != null)
            return customersService.updateName();
        else return "Empty request";
    }

    @GetMapping("/updateImg")
    String changeImg() {
        if (customersService.updateImg() != null)
            return customersService.updateImg();
        else return "Empty request";
    }


}