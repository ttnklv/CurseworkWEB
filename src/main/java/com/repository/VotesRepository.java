package com.repository;

import com.database.VotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface VotesRepository extends JpaRepository<VotesEntity, Long> {

    @Modifying
    @Query(value = "insert into votes(id, count_positive, count_negative, name, id_film, flag_access, votes_image_url)" +
            " VALUES(:id, :count_positive, :count_negative, :name, :id_film, :flag_access, :votes_image_url) ",
            nativeQuery = true)
    @Transactional
    void createVote(@Param("id") int id, @Param("count_positive") int count_positive,
                    @Param("count_negative") int count_negative, @Param("name") String name, @Param("id_film") int id_film,
                    @Param("flag_access") int flag_access, @Param("votes_image_url") String votes_image_url);

    List<VotesEntity> findAllByFlagAccessLike(boolean access);

    VotesEntity findById(int id);

    List<VotesEntity> findAllByFilmByIdFilmIsLike(int id_film);

    @Modifying
    @Transactional
    @Query("update VotesEntity u set u.countNegative = :countNegative where u.id = :id")
    void updateNegative(@Param("countNegative") int countNegative, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update VotesEntity u set u.countPositive = :countPositive where u.id = :id")
    void updatePositive(@Param("countPositive") int countPositive, @Param("id") int id);

}
