package com.repository;

import com.database.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {

    FilmEntity findById(int id);
}
