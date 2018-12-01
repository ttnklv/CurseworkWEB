package com.repository;

import com.database.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Long> {

    List<PostTagEntity> findAllByIdTag(int id);

}
