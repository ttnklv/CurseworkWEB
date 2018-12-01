package com.repository;

import com.database.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    List<ChatEntity> findAll();

    List<ChatEntity> findAllByFilmIdIsLikeOrderByCreateDateAsc(int id_film);

    @Modifying
    @Query(value = "insert into chat (id, film_id, msg, user_us_id, create_date) VALUES (:id, :film_id, :msg, :user_us_id, :create_date)", nativeQuery = true)
    @Transactional
    void newMessege(@Param("id") int id, @Param("film_id") int film_id, @Param("msg") String msg, @Param("user_us_id") int user_us_id, @Param("create_date") Date create_date);

    List<ChatEntity> findAllByUserUsId(int user_id);

    @Modifying
    @Query(value = "insert into chat_user (id_us, id_chat, id) VALUES (:id_us, :id_chat, :id)", nativeQuery = true)
    @Transactional
    void addUser(@Param("id_us") int id_us, @Param("id_chat") int id_chat, @Param("id") int id);

    ChatEntity findById(int id);

}
