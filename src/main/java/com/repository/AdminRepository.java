package com.repository;

import com.database.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {


    @Query(value = "select a from AdminEntity a where a.password = :password")
    AdminEntity findByPassword(@Param("password") String password);

//    AdminEntity findAdminEntitiesByPassword(String password);
}
