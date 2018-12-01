package com.repository;


import com.database.FollowerActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowerActorRepository extends JpaRepository<FollowerActorEntity, Long> {

    @Modifying
    @Query(value = "insert into follower_actor(id_customers, id_actor) VALUES (:id_customers, :id_actor)",
            nativeQuery = true)
    @Transactional
    void insertFollowerActor(@Param("id_customers") int id_customers, @Param("id_actor") int id_actor);

    @Transactional
    @Modifying
    void deleteAllByIdCustomersLikeAndIdActorLike(int id_customers, int id_actor);

    List<FollowerActorEntity> findByIdCustomers(int id_actor);
}
