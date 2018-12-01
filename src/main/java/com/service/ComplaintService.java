package com.service;

import com.database.ComplaintEntity;
import com.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repository;

    @Autowired
    public ComplaintService(ComplaintRepository repository){this.repository = repository;}

    public String returnAnswers() {
        try {
            StringBuilder allAnswers = new StringBuilder();
            List<ComplaintEntity> complaintEntities= repository.findComplaintEntitiesById(1);
            for (ComplaintEntity complaintEntity : complaintEntities) {
                allAnswers.append(complaintEntity.getAnswer());
                allAnswers.append("\n");
            }
            return allAnswers.toString();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String returnAllComplaintForDevelopers(){
        String allComplains = "";
        List<ComplaintEntity> complaintEntities= repository.findComplaintEntitiesByIdNotNull();
        for (ComplaintEntity complaintEntity : complaintEntities) {
            allComplains = allComplains + " Пользователь: ";
//            allComplains = allComplains + complaintEntity.getIdCustomers();
            allComplains = allComplains + " Сообщение: ";
            allComplains = allComplains + complaintEntity.getBody();
            allComplains = allComplains + ("\n");
        }

        return allComplains;
    }
}
