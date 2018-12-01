package com.service;

import com.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {

    private final
    CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customerRepository) {
        this.customersRepository = customerRepository;
    }

    public String updateEmail() {
        try {
            customersRepository.findCustomersEntityById(1).setEmailHash("tanya@mail.ru");
            customersRepository.updateUserSetEmailForId("tanya@mail.ru", 1);
            return "Email was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateLevelAccess() {
        try {
            customersRepository.findCustomersEntityById(1).setLevelAccess(2);
            customersRepository.updateUserSetLevelAccessForId(2,1);
            return "Level_Access was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updatePassword() {
        try {
            customersRepository.findCustomersEntityById(1).setPassword("root");
            customersRepository.updateUserSetPasswordForId("root", 1);
            return "Password was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateMobailNumber() {
        try {
            customersRepository.findCustomersEntityById(1).setMobNumber("89012343948");
            customersRepository.updateUserSetMobailNumberForId("89012343948", 1);
            return "Mobail_Number was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateName() {
        try {
            customersRepository.findCustomersEntityById(1).setName("Танечка");
            customersRepository.updateUserSetMobailNumberForId("Танечка", 1);
            return "Name was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateImg() {
        byte[] img = {1,2,3,4,5,6};
        try {
            customersRepository.findCustomersEntityById(1).setImg(img);
            customersRepository.updateUserSetIMGForId(img,1);
            return "IMG was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
