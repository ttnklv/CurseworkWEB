package com.service;

import com.database.CustomersEntity;
import com.database.FollowerActorEntity;
import com.database.FollowerAnalystEntity;
import com.database.FollowerStudioEntity;
import com.repository.CustomersRepository;
import com.repository.FollowerActorRepository;
import com.repository.FollowerAnalystRepository;
import com.repository.FollowerStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FollowerService {

    private final FollowerActorRepository followerActorRepository;
    private final FollowerAnalystRepository followerAnalystRepository;
    private final FollowerStudioRepository followerStudioRepository;
    private final CustomersRepository customersRepository;

    @Autowired
    public FollowerService(FollowerStudioRepository followerStudioRepository,
                           FollowerAnalystRepository followerAnalystRepository,
                           FollowerActorRepository followerActorRepository,
                           CustomersRepository customersRepository) {
        this.followerActorRepository = followerActorRepository;
        this.followerAnalystRepository = followerAnalystRepository;
        this.followerStudioRepository = followerStudioRepository;
        this.customersRepository = customersRepository;
    }

    public String insertIntoFollowerStudio() {
        try {
            followerStudioRepository.insertFollowerStudio(1, 2);
            return "You signed up for the Studio";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String insertIntoFollowerActor() {
        try {
            followerActorRepository.insertFollowerActor(1, 3);
            return "You signed up for the Actor";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String insertIntoFollowerAnalyst() {
        try {
            followerAnalystRepository.insertFollowerAnalyst(1, 4);
            return "You signed up for the Analyst";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void deleteFollowersStudio() {
        try {
            followerStudioRepository.deleteAllByIdCustomersLikeAndIdStudioLike(1, 1);
        } catch (NullPointerException ignored) {
        }
    }

    public void deleteFollowersActor() {
        try {
            followerActorRepository.deleteAllByIdCustomersLikeAndIdActorLike(1, 1);
        } catch (NullPointerException ignored) {
        }
    }

    public void deleteFollowersAnalyst() {
        try {
            followerAnalystRepository.deleteAllByIdCustomersLikeAndIdAnalystLike(1, 1);
        } catch (NullPointerException ignored) {
        }
    }

    public String getFollowerIMGForStudio() {
        try {
            List<FollowerStudioEntity> followerStudioEntities = followerStudioRepository.findByIdCustomers(1);
            String imgAndName = "";

            for (FollowerStudioEntity followerStudioEntity : followerStudioEntities) {
                int idOneOfStudios = followerStudioEntity.getIdStudio();

                CustomersEntity customersEntity = customersRepository.findCustomersEntityById(idOneOfStudios);
                imgAndName = "Name: " + customersEntity.getName()
                        + "Photo: " + Arrays.toString(customersEntity.getImg()) + "   ";
            }
            return imgAndName;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String getFollowerIMGForActor() {
        try {
            List<FollowerActorEntity> followerActorEntities = followerActorRepository.findByIdCustomers(1);
            String imgAndName = "";

            for (FollowerActorEntity followerActorEntity : followerActorEntities) {
                int idOneOfActor = followerActorEntity.getIdActor();

                CustomersEntity customersEntity = customersRepository.findCustomersEntityById(idOneOfActor);
                imgAndName = "Name: " + customersEntity.getName()
                        + "Photo: " + Arrays.toString(customersEntity.getImg()) + "   ";
            }
            return imgAndName;
        } catch (NullPointerException ex) {
            return null;
        }
    }


    public String getFollowerIMGForAnalyst() {
        try {
            List<FollowerAnalystEntity> followerAnalystEntities = followerAnalystRepository.findByIdCustomers(1);
            String imgAndName = "";

            for (FollowerAnalystEntity followerAnalystEntity : followerAnalystEntities) {
                int idOneOfAnalyst = followerAnalystEntity.getIdAnalyst();

                CustomersEntity customersEntity = customersRepository.findCustomersEntityById(idOneOfAnalyst);
                imgAndName = "Name: " + customersEntity.getName()
                        + "Photo: " + Arrays.toString(customersEntity.getImg()) + "   ";
            }
            return imgAndName;
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
