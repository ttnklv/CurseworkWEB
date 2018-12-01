package com.repository;

import com.database.ComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<ComplaintEntity,Long> {


    List<ComplaintEntity> findComplaintEntitiesById(int id_customers);

    List<ComplaintEntity> findComplaintEntitiesByIdNotNull();
}
