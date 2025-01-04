package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.SessionItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionItemsInfoRepo extends JpaRepository<SessionItemsModel, Integer> {
    @Query(value = "select session_item_id from session_items_table", nativeQuery = true)
    List<Long> findAllSessionItemIdsUsingNativeQuery();
}
