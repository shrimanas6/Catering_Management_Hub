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
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        customerInfoEntry.setCustomerId(maxId != 0 ? (maxId+1) : 1);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        customerInfoEntry.setCreatedDate(formattedDateString);
        this.customer = customerInfoEntry;
        customerRepo.save(customerInfoEntry);
        System.out.println("Customer Information saved successfully...!");
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

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = customerRepo.findAllCustomerIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
