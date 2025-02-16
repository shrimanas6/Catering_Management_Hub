package com.catering.catering_hub.repository.custom_repo;

import com.catering.catering_hub.models.CateringOrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CateringDetailsBulkFetchRepo extends JpaRepository<CateringOrdersModel, Integer> {

    @Query(value = "SELECT * FROM orders_table o left outer join sessions_table st on o.order_id = st.order_id \n" +
            "left outer join session_items_table sit on st.session_id = sit.session_id WHERE o.order_id = :orderId\n" +
            "ORDER BY st.session_id ASC", nativeQuery = true)
    List<Object[]> findBulkSessionsDetails(@Param("orderId") String orderId);

    @Query(value = "select * from customers_master cm left outer join orders_table o on cm.customer_id = o.customer_id \n" +
            "left outer join sessions_table st on o.order_id = st.order_id  left outer join session_items_table sit \n" +
            "on st.session_id = sit.session_id where o.order_id is not null\n" +
            "order by st.session_id asc", nativeQuery = true)
    List<Object[]> findAllSessionWiseOrderDetails();
}
