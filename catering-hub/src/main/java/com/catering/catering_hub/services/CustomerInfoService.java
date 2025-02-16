package com.catering.catering_hub.services;

import com.catering.catering_hub.models.CustomerInfoModel;

import java.util.List;
import java.util.Optional;

public interface CustomerInfoService {

    CustomerInfoModel saveCustomer(CustomerInfoModel customerInfo);
    List<CustomerInfoModel> getAllCustomers();
    Optional<CustomerInfoModel> getCustomerById(Integer customerId);
    String deleteCustomerById(Integer customerId);
    String deleteAllCustomers();
}
