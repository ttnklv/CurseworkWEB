package com.repository;


import com.database.ChatUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ChatUserRepository extends JpaRepository<ChatUserEntity, Long> {

    @Modifying
    @Query(value = "insert into chat_user(id_us, id_chat, id) values (:id_us, :id_chat, :id)", nativeQuery = true)
    @Transactional
    void newChatToUser(@Param("id_us") int id_us, @Param("id_chat") int id_chat, @Param("id") int id);

    List<ChatUserEntity> findChatUserEntitiesByIdUsLike(int id_user);

}
