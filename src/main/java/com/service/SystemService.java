package com.service;

import com.database.TransactionEntity;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    private final SystemRepository systemRepository;
    private final TransactionRepository transactionRepository;
    private final StudioRepository studioRepository;
    private final AnalystRepository analystRepository;

    @Autowired
    public SystemService(SystemRepository systemRepository, TransactionRepository transactionRepository,
                         StudioRepository studioRepository, AnalystRepository analystRepository) {
        this.systemRepository = systemRepository;
        this.transactionRepository = transactionRepository;
        this.analystRepository = analystRepository;
        this.studioRepository = studioRepository;
    }

//    AdminEntity adminWithSimplePassword = adminRepository.findAdminEntitiesByPassword("root");//findByPassword("root");

    public String returnInfo() {
        try {
            return systemRepository.findById(1).getName() + "\n" + systemRepository.findById(1).getAdminMail()
                    + "\n" + systemRepository.findById(1).getBody();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String moneyTransfer() {
        try {
            long money = 15;
            int id_studio = 3;
            int id_analyst = 4;
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setIdRecipient(id_analyst);
            transactionEntity.setIdSender(id_studio);
            transactionEntity.setSum(money);
            studioRepository.updatePurse(studioRepository.findByIdStudio(id_studio).getPurse() - money, id_studio);
            analystRepository.updatePurse(analystRepository.findByIdAnalyst(id_analyst).getPurse() + money, id_analyst);
            transactionRepository.save(transactionEntity);
            return "Successful done";
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
