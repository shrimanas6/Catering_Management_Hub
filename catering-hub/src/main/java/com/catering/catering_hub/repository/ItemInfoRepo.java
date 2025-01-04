package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.ItemMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemInfoRepo extends JpaRepository<ItemMasterModel, Integer> {
    @Query(value = "select item_id from items_master", nativeQuery = true)
    List<Long> findAllItemIdsUsingNativeQuery();
}
