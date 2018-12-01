package com.service;

import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final
    AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

//    AdminEntity adminWithSimplePassword = adminRepository.findAdminEntitiesByPassword("root");//findByPassword("root");

    public String returnLogin() {
        try {
            return adminRepository.findByPassword("root").getLogin();
        } catch (NullPointerException ex) {
            return null;
        }
    }


}
