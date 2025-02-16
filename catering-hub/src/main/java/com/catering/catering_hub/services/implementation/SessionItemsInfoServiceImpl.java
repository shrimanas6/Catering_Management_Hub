package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.SessionItemsModel;
import com.catering.catering_hub.repository.SessionItemsInfoRepo;
import com.catering.catering_hub.services.SessionItemsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SessionItemsInfoServiceImpl implements SessionItemsInfoService {

    @Autowired
    private SessionItemsInfoRepo sessionItemsInfoRepo;

    @Autowired
    private SessionInfoServiceImpl sessionInfoServiceImpl;

    private List<SessionItemsModel> orderItemsList;

    @Override
    public SessionItemsModel saveSessionItemsInfo(SessionItemsModel sessionItems) {
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        sessionItems.setCreatedDate(formattedDateString);
        sessionItems.setModifiedDate(formattedDateString);
        sessionItems.setSessionItemId(maxId != 0 ? (maxId+1) : 1);
        sessionItems.setSessionId(sessionInfoServiceImpl.getSessionsModel().getSessionId());
        return sessionItemsInfoRepo.save(sessionItems);
    }

    @Override
    public void saveSessionItemsInfoList(SessionItemsModel sessionItems) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        int sessionItemId = sessionItems.getSessionItemId() != null ?
                sessionItems.getSessionItemId() : 0;

        sessionItems.setCreatedDate(sessionItemId > 0 &&
                sessionItems.getCreatedDate() != null ? sessionItems.getCreatedDate() :
                formattedDateString);
        sessionItems.setModifiedDate(formattedDateString);

        int maxId = sessionItemId > 0 ? sessionItemId : (orderItemsList != null ? orderItemsList.stream()
                .map(SessionItemsModel::getSessionItemId)
                .max(Integer::compareTo)
                .orElse(findMaxId() != null ? findMaxId().intValue() : 0) :
                (findMaxId() != null ? findMaxId().intValue() : 0));

        sessionItems.setSessionItemId(sessionItemId > 0 ? sessionItemId : maxId != 0 ? (maxId+1) : 1);
//        sessionItems.setSessionId(sessionInfoServiceImpl.getSessionsModel().getSessionId());
        this.orderItemsList.add(sessionItems);
    }

    @Override
    public void saveSessionItemsFilteredInfo(List<SessionItemsModel> sessionItemsList) {
        orderItemsList = new ArrayList<>();
        for(SessionItemsModel items : sessionItemsList){
            saveSessionItemsInfoList(items);
        }
    }

    @Override
    public List<SessionItemsModel> saveOrderItemsList() {
        sessionItemsInfoRepo.saveAll(orderItemsList);
        System.out.println("!!------Order Placed Successfully-----!!");
        return orderItemsList;
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
