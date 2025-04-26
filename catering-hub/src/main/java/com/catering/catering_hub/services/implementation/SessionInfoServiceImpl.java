package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.SessionItemsModel;
import com.catering.catering_hub.models.SessionsModel;
import com.catering.catering_hub.models.order_models.SessionItemsJsonModel;
import com.catering.catering_hub.models.order_models.SessionsJsonModel;
import com.catering.catering_hub.repository.SessionInfoRepo;
import com.catering.catering_hub.services.SessionInfoService;
import com.catering.catering_hub.services.SessionItemsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SessionInfoServiceImpl implements SessionInfoService {

    @Autowired
    private SessionInfoRepo sessionRepo;
    private SessionsModel sessionsModel;
    private List<SessionsModel> sessionsModelList;
    @Autowired
    private CateringOrderServiceImpl cateringOrderImpl;

    @Autowired
    public SessionInfoServiceImpl(SessionInfoRepo sessionInfoRepo) {
        this.sessionRepo = sessionInfoRepo;
    }

    @Override
    public SessionsModel saveOrderSession(SessionsModel sessions) {
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        sessions.setCreatedDate(formattedDateString);
        sessions.setModifiedDate(formattedDateString);
        sessions.setSessionId(maxId != 0 ? (maxId+1) : 1);
        sessions.setOrderId(cateringOrderImpl.getCateringOrdersModel().getOrderId());
        this.sessionsModel = sessions;
        return sessionRepo.save(sessions);
    }

    @Override
    public List<SessionsModel> saveSessionsList(List<SessionsModel> sessionsList) {
        sessionsList.forEach(this::saveOrderSessionList);
        List<SessionItemsModel> sessionItemsModelList = new ArrayList<>();
        for(SessionsModel sessionItems : sessionsList){
//            sessionItemsModelList.add(sessionItems.getSessionItemsModelList());
//            for(SessionItemsModel items : sessionItems.getSessionItemsModelList()){
//                if(sessionItems.getSessionId() != null && items.getSessionId().equals(sessionItems.getSessionId())) {
//                    sessionItemsService.saveSessionItemsInfoList(items);
//                }
//            }
        }
//        sessionRepo.saveAll(sessionsModelList);
//        sessionItemsService.saveOrderItemsList();
        return sessionsList;
    }

    @Override
    public List<SessionItemsModel>  saveSessionsJsonList(List<SessionsJsonModel> sessionsList) {
        final boolean[] isUpdate = {false};
        sessionsModelList = new ArrayList<>();
        List<SessionItemsModel> orderItemsList = new ArrayList<>();
        sessionsList.forEach(this::saveJsonOrderSessionList);
        List<SessionsJsonModel> sessionItemsModelList = new ArrayList<>();
        sessionsList.stream()
                .flatMap(sessionItems -> sessionItems.getSessionItemsJsonModels().stream()
                        .map(items -> {
                            SessionItemsModel itemsModel = new SessionItemsModel();
                            // Use sessionItems.getSessionId() within this scope
                            itemsModel.setSessionId(sessionItems.getSessionId());
                            itemsModel.setItemId(items.getItemId());
                            itemsModel.setItemDesc(items.getItemDesc());
                            itemsModel.setSubItemId(items.getSubItemId());
                            itemsModel.setCreatedDate(items.getCreatedDate());
                            itemsModel.setSessionItemId(items.getSessionItemId());
                            if(itemsModel.getSessionItemId() != null && itemsModel.getSessionItemId() > 0){
                                isUpdate[0] = true;
                            }
                            itemsModel.setCreatedBy(items.getCreatedBy());
                            itemsModel.setModifiedBy(items.getModifiedBy());
                            itemsModel.setModifiedDate(items.getModifiedDate());
                            return itemsModel;
                        })
                )
                .forEach(orderItemsList::add);
        sessionRepo.saveAll(sessionsModelList);
        if(isUpdate[0]){
            System.out.println("Session Information updated successfully");
        } else {
            System.out.println("Session Information saved successfully");
        }
        return orderItemsList;
    }

    @Override
    public List<SessionsModel> getSessionInfoListById(String orderId) {
        return sessionRepo.findAllByCustomerId(orderId);
    }

    public SessionsModel getSessionsModel(){
        return sessionsModel;
    }

    public List<SessionsModel> getSessionsModelList(){
        return sessionsModelList;
    }

    public void saveOrderSessionList(SessionsModel sessions) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        sessions.setCreatedDate(formattedDateString);
        sessions.setModifiedDate(formattedDateString);
        Integer maxId = (sessionsModelList != null ? sessionsModelList.stream()
                .map(SessionsModel::getSessionId)
                .max(Integer::compareTo)
                .orElse(findMaxId() != null ? findMaxId().intValue() : 0) :
                (findMaxId() != null ? findMaxId().intValue() : 0));

        sessions.setSessionId(maxId != 0 ? (maxId+1) : 1);
        sessions.setOrderId(cateringOrderImpl.getCateringOrdersModel().getOrderId());
        this.sessionsModel = sessions;
        this.sessionsModelList.add(sessions);
    }

    public void saveJsonOrderSessionList(SessionsJsonModel sessions) {
        SessionsModel sessionsModel = new SessionsModel();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);
        int sessionId = sessions.getSessionId() != null ? sessions.getSessionId() : 0;

        sessions.setCreatedDate(sessionId > 0 && sessions.getCreatedDate() != null ? sessions.getCreatedDate() : formattedDateString);
        sessions.setModifiedDate(formattedDateString);

        int maxId = sessionId > 0 ? sessionId : (sessionsModelList != null ? sessionsModelList.stream()
                .map(SessionsModel::getSessionId)
                .max(Integer::compareTo)
                .orElse(findMaxId() != null ? findMaxId().intValue() : 0) :
                (findMaxId() != null ? findMaxId().intValue() : 0));

        sessions.setSessionId(sessionId > 0 ? sessionId : maxId != 0 ? (maxId+1) : 1);
        sessions.setOrderId(cateringOrderImpl != null ? cateringOrderImpl.getCateringOrdersModel().getOrderId() : "1");

        sessionsModel.setOrderId(sessions.getOrderId());
        sessionsModel.setSessionDescription(sessions.getSessionDescription());
        sessionsModel.setSessionName(sessions.getSessionName());
        sessionsModel.setSessionQuantity(sessions.getSessionQuantity());
        sessionsModel.setSessionId(sessions.getSessionId());
        sessionsModel.setEventAddress(sessions.getEventAddress());
        sessionsModel.setEventDate(sessions.getEventDate());
        sessionsModel.setEventLocation(sessions.getEventLocation());
        sessionsModel.setSessionBeginTime(sessions.getSessionBeginTime());
        sessionsModel.setSessionEndTime(sessions.getSessionEndTime());
        sessionsModel.setModifiedBy(sessions.getModifiedBy());
        sessionsModel.setModifiedDate(sessions.getModifiedDate());
        sessionsModel.setCreatedBy(sessions.getCreatedBy());
        sessionsModel.setCreatedDate(sessions.getCreatedDate());
        this.sessionsModel = sessionsModel;
        this.sessionsModelList.add(sessionsModel);
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
