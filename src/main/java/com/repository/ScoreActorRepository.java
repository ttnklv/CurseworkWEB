package com.repository;

import com.database.ScoreActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreActorRepository extends JpaRepository<ScoreActorEntity, Long> {

    List<ScoreActorEntity> findAllByIdActor(int id_actor);
}
