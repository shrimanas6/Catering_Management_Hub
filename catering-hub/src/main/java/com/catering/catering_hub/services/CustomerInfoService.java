package com.catering.catering_hub.services;

import com.catering.catering_hub.models.CustomerInfoModel;

import java.util.List;

public interface CustomerInfoService {

    CustomerInfoModel saveCustomer(CustomerInfoModel customerInfo);
    List<CustomerInfoModel> getAllCustomers();
}
