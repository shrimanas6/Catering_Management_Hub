package com.catering.catering_hub.repository;

import com.catering.catering_hub.models.CateringOrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CateringOrderInfoRepo extends JpaRepository<CateringOrdersModel, Integer> {

}
