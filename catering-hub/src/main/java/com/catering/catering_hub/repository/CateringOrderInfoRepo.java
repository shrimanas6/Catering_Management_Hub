package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.CateringOrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CateringOrderInfoRepo extends JpaRepository<CateringOrdersModel, Integer> {
    @Query(value = "select * from orders_table where customer_id = :customerId", nativeQuery = true)
    CateringOrdersModel findOrderNoteUsingNativeQuery(@Param("customerId") Integer customerId);
}
