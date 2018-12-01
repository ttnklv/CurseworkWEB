package com.repository;

import com.database.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {

    CustomersEntity findCustomersEntityById(int id);

    @Modifying
    @Transactional
    @Query("update CustomersEntity u set u.emailHash = :emailHash where u.id = :id")
    void updateUserSetEmailForId(@Param("emailHash") String email, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update CustomersEntity u set u.password = :password where u.id = :id")
    void updateUserSetPasswordForId(@Param("password") String password, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update CustomersEntity u set u.levelAccess = :level_access where u.id = :id")
    void updateUserSetLevelAccessForId(@Param("level_access") int level_access, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update CustomersEntity u set u.mobNumber = :mobNumber where u.id = :id")
    void updateUserSetMobailNumberForId(@Param("mobNumber") String mobNumber, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update CustomersEntity u set u.name = :name where u.id = :id")
    void updateUserSetNameForId(@Param("name") String name, @Param("id") int id);

    @Modifying
    @Transactional
    @Query("update CustomersEntity u set u.img = :img where u.id = :id")
    void updateUserSetIMGForId(@Param("img") byte[] img, @Param("id") int id);

}
