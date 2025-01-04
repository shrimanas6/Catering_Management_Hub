package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.SessionItemsModel;
import com.catering.catering_hub.repository.SessionItemsInfoRepo;
import com.catering.catering_hub.services.SessionItemsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SessionItemsInfoServiceImpl implements SessionItemsInfoService {

    @Autowired
    private SessionItemsInfoRepo sessionItemsInfoRepo;

    @Override
    public SessionItemsModel saveSessionItemsInfo(SessionItemsModel sessionItems) {
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        sessionItems.setCreatedDate(formattedDateString);
        sessionItems.setModifiedDate(formattedDateString);
        sessionItems.setSessionId(maxId != 0 ? (maxId+1) : 1);
        return sessionItemsInfoRepo.save(sessionItems);
    }

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = sessionItemsInfoRepo.findAllSessionItemIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
