package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.CateringOrdersModel;
import com.catering.catering_hub.repository.CateringOrderInfoRepo;
import com.catering.catering_hub.services.CateringOrdersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CateringOrderServiceImpl implements CateringOrdersInfoService {

    @Autowired
    private CateringOrderInfoRepo ordersRepo;

    @Override
    public CateringOrdersModel saveCateringOrderInfo(CateringOrdersModel cateringOrder) {
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        cateringOrder.setCreatedDate(formattedDateString);
        cateringOrder.setOrderId(maxId != 0 ? (maxId+1) : 1);
        return ordersRepo.save(cateringOrder);
    }

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = ordersRepo.findAllOrderIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
