package com.repository;


import com.database.FollowerStudioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowerStudioRepository extends JpaRepository<FollowerStudioEntity, Long> {

    @Modifying
    @Query(value = "insert into follower_studio(id_customers, id_studio) VALUES (:id_customers, :id_studio)",
            nativeQuery = true)
    @Transactional
    void insertFollowerStudio(@Param("id_customers") int id_customers, @Param("id_studio") int id_studio);

    @Transactional
    @Modifying
    void deleteAllByIdCustomersLikeAndIdStudioLike(int id_customers, int id_studio);

    List<FollowerStudioEntity> findByIdCustomers(int id);
}
