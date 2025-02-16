package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.CateringOrdersModel;
import com.catering.catering_hub.models.SessionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionInfoRepo extends JpaRepository<SessionsModel, Integer> {
    @Query(value = "select session_id from sessions_table", nativeQuery = true)
    List<Long> findAllSessionIdsUsingNativeQuery();

    @Query(value = "select * from sessions_table where order_id = :orderId", nativeQuery = true)
    List<SessionsModel> findAllByCustomerId(@Param("orderId") String orderId);
}
