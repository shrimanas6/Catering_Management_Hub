package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.CateringOrdersModel;
import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;
import com.catering.catering_hub.repository.CateringOrderInfoRepo;
import com.catering.catering_hub.services.CateringOrdersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CateringOrderServiceImpl implements CateringOrdersInfoService {

    @Autowired
    private CateringOrderInfoRepo ordersRepo;

    @Autowired
    private CustomerInfoServiceImpl customerImpll;
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
        caterer.setOrderId(customerImpll.getCustomer().getCustomerMobile() + customerImpll.getCustomer().getCustomerId());
        caterer.setCustomerId(customerImpll.getCustomer().getCustomerId());
        caterer.setCreatedDate(formattedDateString);
        System.out.println("OrderId : "+caterer.getOrderId());
        this.cateringOrdersModel = caterer;
        ordersRepo.save(caterer);
    }

    public CateringOrdersModel getCateringOrdersModel(){
        return cateringOrdersModel;
    }
}
