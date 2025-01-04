package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoModel, Integer> {

    @Query(value = "SELECT USER_ID FROM user_Master", nativeQuery = true)
    List<Long> findAllUserIdsUsingNativeQuery();
}
