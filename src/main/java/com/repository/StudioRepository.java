package com.repository;

import com.database.StudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudioRepository extends JpaRepository<StudioEntity,Long> {
    StudioEntity findByIdStudio(int id_studio);

    @Modifying
    @Transactional
    @Query("update StudioEntity u set u.purse = :purse where u.id = :id")
    void updatePurse(@Param("purse") long purse, @Param("id") int id);
}
