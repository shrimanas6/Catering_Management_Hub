package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.CustomerInfoModel;
import com.catering.catering_hub.repository.CustomerInfoRepo;
import com.catering.catering_hub.services.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final CustomerInfoRepo customerRepo;
    private CustomerInfoModel customer;

    @Autowired
    public CustomerInfoServiceImpl(CustomerInfoRepo customerInfoRepo) {
        this.customerRepo = customerInfoRepo;
    }

    @Override
    public CustomerInfoModel saveCustomer(CustomerInfoModel customerInfoEntry) {
        int customerId = customerInfoEntry.getCustomerId() != null ? customerInfoEntry.getCustomerId() : 0;
        int maxId = customerId > 0 ? customerId : findMaxId() != null ? findMaxId().intValue() : 0;
        customerInfoEntry.setCustomerId(customerId > 0 ? customerId : maxId != 0 ? (maxId+1) : 1);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        customerInfoEntry.setCreatedDate(formattedDateString);
        this.customer = customerInfoEntry;
        customerRepo.save(customerInfoEntry);
        if(customerId > 0) {
            System.out.println("Customer Information updated successfully...!");
        }
        else {
            System.out.println("Customer Information saved successfully...!");
        }
        return customerInfoEntry;
    }

    public CustomerInfoModel getCustomer(){
        return customer;
    }
    @Override
    public List<CustomerInfoModel> getAllCustomers() {
        System.out.println("Loading");
        return customerRepo.findAll();
    }

    @Override
    public Optional<CustomerInfoModel> getCustomerById(Integer customerId) {
        return customerRepo.findById(customerId);
    }

    @Override
    public String deleteCustomerById(Integer customerId) {
        customerRepo.deleteById(customerId);
        return "Customer Info Deleted Successfully";
    }

    @Override
    public String deleteAllCustomers() {
        customerRepo.deleteAll();
        return "All Customer Deleted Successfully";
    }

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = customerRepo.findAllCustomerIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
