package com.repository;

import com.database.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {


}
