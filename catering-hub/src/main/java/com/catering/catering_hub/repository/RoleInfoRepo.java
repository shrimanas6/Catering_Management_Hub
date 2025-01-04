package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.RoleInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleInfoRepo extends JpaRepository<RoleInfoModel, Integer> {

    @Query(value = "select role_id from roles_master", nativeQuery = true)
    List<Long> findAllRoleIdsUsingNativeQuery();

}
