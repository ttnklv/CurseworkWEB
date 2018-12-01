package com.repository;

import com.database.ScoreFilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreFilmRepository extends JpaRepository<ScoreFilmEntity, Long> {

    List<ScoreFilmEntity> findAllByIdFilm(int id_film);
}
