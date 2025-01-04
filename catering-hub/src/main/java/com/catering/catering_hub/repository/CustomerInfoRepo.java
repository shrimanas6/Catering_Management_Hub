package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.CustomerInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface CustomerInfoRepo extends JpaRepository<CustomerInfoModel, Integer> {

    @Query(value = "SELECT customer_id FROM customers_master", nativeQuery = true)
    List<Long> findAllCustomerIdsUsingNativeQuery();
}
