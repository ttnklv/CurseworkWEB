package com.repository;


import com.database.FollowerAnalystEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowerAnalystRepository extends JpaRepository<FollowerAnalystEntity, Long> {

    @Modifying
    @Query(value = "insert into follower_analyst(id_customers, id_analyst) VALUES (:id_customers, :id_analyst)",
            nativeQuery = true)
    @Transactional
    void insertFollowerAnalyst(@Param("id_customers") int id_customers, @Param("id_analyst") int id_analyst);

    @Transactional
    @Modifying
    void deleteAllByIdCustomersLikeAndIdAnalystLike(int id_customers, int id_analyst);

    List<FollowerAnalystEntity> findByIdCustomers(int id);
}
