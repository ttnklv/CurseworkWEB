package com.service;

import com.database.VotesEntity;
import com.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VotesService {

    private final VotesRepository votesRepository;

    @Autowired
    public VotesService(VotesRepository votesRepository) {
        this.votesRepository = votesRepository;
    }

    public String addNewVote() {
        try {
//            chatRepository.save(new ChatEntity(1,2,"cool",1,date));
            votesRepository.createVote(1, 2, 1, "Король Лев про льва?",
                    1, 1, "lib");
            return "Create new Vote";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findAllAccessVote() {
        try {
            StringBuilder votes = new StringBuilder();
            List<VotesEntity> entities = votesRepository.findAllByFlagAccessLike(true);
            for (VotesEntity entity : entities) {
                votes.append("name: ").append(entity.getName());
            }
            return String.valueOf(votes);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String recalculation() {
        try {
            VotesEntity votesEntity = votesRepository.findById(1);
            boolean choice = true;
            if (choice) votesRepository.updatePositive(votesEntity.getCountPositive() + 1, 1);
            else votesRepository.updateNegative(votesEntity.getCountNegative() + 1, 1);
            return "пересчитано";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findAllVotesForFilm() {
        try {
            List<VotesEntity> entities = votesRepository.findAllByFilmByIdFilmIsLike(1);
            StringBuilder answer = new StringBuilder();
            for (VotesEntity entity : entities) {
                answer.append("Name: ").append(entity.getName())
                        .append("Negative: ").append(entity.getCountNegative())
                        .append("Positive: ").append(entity.getCountPositive())
                        .append("IMG: ").append(Arrays.toString(entity.getVotesImageUrl()));
            }
            return String.valueOf(answer);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String findInfoForVote() {
        try {
            int id_vote = 1;
            VotesEntity votesEntity = votesRepository.findById(id_vote);
            return "  Name:  " + votesEntity.getName() + "  Pos: "
                    + votesEntity.getCountPositive() + "  Neg:  " + votesEntity.getCountNegative();
        } catch (NullPointerException ex) {
            return null;
        }
    }

}
