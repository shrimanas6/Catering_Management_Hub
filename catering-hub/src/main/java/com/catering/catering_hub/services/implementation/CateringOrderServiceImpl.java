package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.CateringOrdersModel;
import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;
import com.catering.catering_hub.repository.CateringOrderInfoRepo;
import com.catering.catering_hub.services.CateringOrdersInfoService;
import lombok.Getter;
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

    @Autowired
    private CustomerInfoServiceImpl customerImpll;
    @Getter
    private CateringOrdersModel cateringOrdersModel;

    @Override
    public CateringOrdersModel saveCateringOrderInfo(CateringOrdersModel cateringOrder) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        cateringOrder.setCreatedDate(formattedDateString);
        cateringOrder.setOrderId(customerImpll.getCustomer().getCustomerMobile() + customerImpll.getCustomer().getCustomerId());
        cateringOrder.setCustomerId(customerImpll.getCustomer().getCustomerId());
        System.out.println("OrderId : "+cateringOrder.getOrderId());
        this.cateringOrdersModel = cateringOrder;
        return ordersRepo.save(cateringOrder);
    }

    @Override
    public void saveCateringOrderObjectInfo(CateringOrdersJsonModel cateringOrder) {
        CateringOrdersModel caterer = new CateringOrdersModel();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        caterer.setEventNote(cateringOrder.getEventNote());
        caterer.setCreatedBy(cateringOrder.getCreatedBy());
        int orderId = cateringOrder.getOrderId() != null && !cateringOrder.getOrderId().isEmpty() ? Integer.parseInt(cateringOrder.getOrderId()) : 0;
        int maxId = orderId > 0 ? orderId : findMaxId() != null ? findMaxId().intValue() : 0;
        caterer.setOrderId(String.valueOf(orderId > 0 ? orderId : maxId != 0 ? (maxId+1) : 1));
//        caterer.setOrderId(customerImpll.getCustomer().getCustomerMobile() + customerImpll.getCustomer().getCustomerId());
        caterer.setCustomerId(customerImpll.getCustomer().getCustomerId());
        caterer.setCreatedDate(formattedDateString);
        System.out.println("OrderId : "+caterer.getOrderId());
        this.cateringOrdersModel = caterer;
        ordersRepo.save(caterer);
    }

    @Override
    public Optional<CateringOrdersModel> getOrderNoteInfoById(Integer customerId) {
        return Optional.ofNullable(ordersRepo.findOrderNoteUsingNativeQuery(customerId));
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
