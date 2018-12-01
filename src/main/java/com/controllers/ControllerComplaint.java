package com.controllers;

import com.service.AdminService;
import com.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerComplaint {


    private final ComplaintService complaintService;

    @Autowired
    public ControllerComplaint(ComplaintService complaintService) {
        this.complaintService = complaintService; }

    @GetMapping("/answer")
    String getAns() {
        if (complaintService.returnAnswers() != null)
            return complaintService.returnAnswers();
        else return "Empty request";
    }

    @GetMapping("/allComplains")
    String getComplains() {
        if (complaintService.returnAllComplaintForDevelopers() != null)
            return complaintService.returnAllComplaintForDevelopers();
        else return "Empty request";
    }

}
