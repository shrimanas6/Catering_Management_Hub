package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.SessionsModel;
import com.catering.catering_hub.repository.RoleInfoRepo;
import com.catering.catering_hub.repository.SessionInfoRepo;
import com.catering.catering_hub.services.SessionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SessionInfoServiceImpl implements SessionInfoService {

    @Autowired
    private SessionInfoRepo sessionRepo;

    @Override
    public SessionsModel saveOrderSession(SessionsModel sessions) {
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        sessions.setCreatedDate(formattedDateString);
        sessions.setModifiedDate(formattedDateString);
        sessions.setSessionId(maxId != 0 ? (maxId+1) : 1);
        return sessionRepo.save(sessions);
    }

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = sessionRepo.findAllSessionIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
