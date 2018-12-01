package com.repository;

import com.database.ScoreAnalystEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreAnalystRepository extends JpaRepository<ScoreAnalystEntity, Long> {

    List<ScoreAnalystEntity> findAllByIdAnalyst(int id_analyst);

//    List<ScoreAnalystEntity> findAllByIdAnalyst()
}
