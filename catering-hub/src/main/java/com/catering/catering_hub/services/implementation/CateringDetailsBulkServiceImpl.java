package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;
import com.catering.catering_hub.models.order_models.CustomerInfoJsonModel;
import com.catering.catering_hub.models.order_models.SessionItemsJsonModel;
import com.catering.catering_hub.models.order_models.SessionsJsonModel;
import com.catering.catering_hub.repository.custom_repo.CateringDetailsBulkFetchRepo;
import com.catering.catering_hub.services.CateringDetailsBulkFetchSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CateringDetailsBulkServiceImpl implements CateringDetailsBulkFetchSevice {

    @Autowired
    private CateringDetailsBulkFetchRepo cateringBulkfetchRepo;

    @Override
    public List<CateringOrdersJsonModel> getBulkSessionsInfo(String orderId) {
        List<CateringOrdersJsonModel> objConvertedList = new ArrayList<>();
        return objConvertedList;
    }

    public List<CateringOrdersJsonModel> getSessionsWithItemsFromJoin(String orderID) {
        List<Object[]> results = cateringBulkfetchRepo.findBulkSessionsDetails(orderID);
        Map<Integer, SessionsJsonModel> sessionMap = new HashMap<>();
        Map<String, CateringOrdersJsonModel> cateringOrdersMap = new HashMap<>();

        for (Object[] row : results) {

            String orderId = (String) row[0];
            Integer oTCreateBy = (Integer) row[1];
            String oTCreateDate = (String) row[2];
            String eventNote = (String) row[3];
            Integer customerId = (Integer) row[4];
            Integer sessionId = (Integer) row[5];
            String eventAddress = (String) row[9];
            String eventDate = (String) row[10];
            String eventLocation = (String) row[11];

            Integer sTCreateBy = (Integer) row[6];
            String sTCreateDate = (String) row[7];
            String sessionBeginTime = (String) row[15];
            String sessionDescription = (String) row[16];
            String sessionEndTime = (String) row[17];
            String sessionName = (String) row[18];
            Integer sessionQuantity = (Integer) row[19];
            Integer sTModifiedBy = (Integer) row[12];
            String sTModifiedDate = (String) row[13];

            Integer sessionItemId = (Integer) row[20];
            Integer sITCreateBy = (Integer) row[21];
            String sITCreateDate = (String) row[22];
            String itemDescription = (String) row[23];
            Integer itemId = (Integer) row[24];
            Integer sITModifiedBy = (Integer) row[25];
            String sITModifiedDate = (String) row[26];
            Integer subItemId = (Integer) row[28];

            CateringOrdersJsonModel orderMap = cateringOrdersMap.computeIfAbsent(orderId, id -> {
                CateringOrdersJsonModel s = new CateringOrdersJsonModel();
                s.setOrderId(orderId);
                s.setEventNote(eventNote);
                s.setCustomerId(String.valueOf(customerId));
                s.setCreatedBy(oTCreateBy);
                s.setCreatedDate(oTCreateDate);
                s.setSessionsJsonModel(new ArrayList<>());
                return s;
            });

            // Create session model if it doesn't exist in the map
            SessionsJsonModel session = sessionMap.computeIfAbsent(sessionId, id -> {
                SessionsJsonModel s = new SessionsJsonModel();
                s.setSessionId(sessionId);
                s.setSessionName(sessionName);
                s.setSessionDescription(sessionDescription);
                s.setSessionQuantity(sessionQuantity);
                s.setOrderId(orderId);
                s.setEventAddress(eventAddress);
                s.setEventDate(eventDate);
                s.setEventLocation(eventLocation);
                s.setSessionBeginTime(sessionBeginTime);
                s.setSessionEndTime(sessionEndTime);
                s.setCreatedBy(sTCreateBy);
                s.setCreatedDate(sTCreateDate);
                s.setModifiedBy(sTModifiedBy);
                s.setModifiedDate(sTModifiedDate);
                s.setSessionItemsJsonModels(new ArrayList<>());
                orderMap.getSessionsJsonModel().add(s);
                return s;
            });

            // Only add the item if both itemId and itemName are non-null
            if (itemId != null && sessionItemId != null) {
                SessionItemsJsonModel item = new SessionItemsJsonModel();
                item.setItemId(itemId);
                item.setItemDesc(itemDescription);
                item.setSessionId(sessionId);  // Link item to the session
                item.setSessionItemId(sessionItemId);
                item.setSubItemId(subItemId);
                item.setCreatedBy(sITCreateBy);
                item.setCreatedDate(sITCreateDate);
                item.setModifiedBy(sITModifiedBy);
                item.setModifiedDate(sITModifiedDate);
                session.getSessionItemsJsonModels().add(item);
            }
        }

        return new ArrayList<>(cateringOrdersMap.values());  // Return the list of sessions with items
    }

    @Override
    public List<CateringOrdersJsonModel> getAllOrdersInfo() {
        List<Object[]> results = cateringBulkfetchRepo.findAllSessionWiseOrderDetails();
        Map<String, CateringOrdersJsonModel> cateringOrdersMap = new HashMap<>();
        Map<Integer, SessionsJsonModel> sessionMap = new HashMap<>();

        for (Object[] row : results) {

            Integer cMTCustomerId = (Integer) row[0];
            Integer cMTCreatedBy = (Integer) row[1];
            String cMTCreatedDate = (String) row[2];
            String customerAddress = (String) row[3];
            String customerEmail = (String) row[4];
            String customerMobile = (String) row[5];
            String customerName = (String) row[6];

            String orderId = (String) row[7];
            Integer oTCreateBy = (Integer) row[8];
            String oTCreateDate = (String) row[9];
            String eventNote = (String) row[10];
            Integer customerId = (Integer) row[11];
            Integer sessionId = (Integer) row[12];

            Integer sTCreateBy = (Integer) row[13];
            String sTCreateDate = (String) row[14];

            String eventAddress = (String) row[16];
            String eventDate = (String) row[17];
            String eventLocation = (String) row[18];

            Integer sTModifiedBy = (Integer) row[19];
            String sTModifiedDate = (String) row[20];

            String sessionBeginTime = (String) row[22];
            String sessionDescription = (String) row[23];
            String sessionEndTime = (String) row[24];
            String sessionName = (String) row[25];
            Integer sessionQuantity = (Integer) row[26];

            Integer sessionItemId = (Integer) row[27];
            Integer sITCreateBy = (Integer) row[28];
            String sITCreateDate = (String) row[29];
            String itemDescription = (String) row[30];
            Integer itemId = (Integer) row[31];
            Integer sITModifiedBy = (Integer) row[32];
            String sITModifiedDate = (String) row[33];
            Integer sITSessionId = (Integer) row[34];
            Integer subItemId = (Integer) row[35];

            CateringOrdersJsonModel orderMap = cateringOrdersMap.computeIfAbsent(orderId, id -> {
                CateringOrdersJsonModel s = new CateringOrdersJsonModel();
                s.setOrderId(orderId);
                s.setEventNote(eventNote);
                s.setCustomerId(String.valueOf(customerId));
                s.setCreatedBy(oTCreateBy);
                s.setCreatedDate(oTCreateDate);

                s.setCustomerName(customerName);
                s.setCustomerMobile(customerMobile);
                s.setCustomerEmail(customerEmail);
                s.setCustomerCreatedBy(cMTCreatedBy);
                s.setCustomerCreateDate(cMTCreatedDate);
                s.setCustomerAddress(customerAddress);
                s.setSessionsJsonModel(new ArrayList<>());
                return s;
            });

            // Create session model if it doesn't exist in the map
            SessionsJsonModel session = sessionMap.computeIfAbsent(sessionId, id -> {
                SessionsJsonModel s = new SessionsJsonModel();
                s.setSessionId(sessionId);
                s.setSessionName(sessionName);
                s.setSessionDescription(sessionDescription);
                s.setSessionQuantity(sessionQuantity);
                s.setOrderId(orderId);
                s.setEventAddress(eventAddress);
                s.setEventDate(eventDate);
                s.setEventLocation(eventLocation);
                s.setSessionBeginTime(sessionBeginTime);
                s.setSessionEndTime(sessionEndTime);
                s.setCreatedBy(sTCreateBy);
                s.setCreatedDate(sTCreateDate);
                s.setModifiedBy(sTModifiedBy);
                s.setModifiedDate(sTModifiedDate);
                s.setSessionItemsJsonModels(new ArrayList<>());
                orderMap.getSessionsJsonModel().add(s);
                return s;
            });

            // Only add the item if both itemId and itemName are non-null
            if (itemId != null && sessionItemId != null) {
                SessionItemsJsonModel item = new SessionItemsJsonModel();
                item.setItemId(itemId);
                item.setItemDesc(itemDescription);
                item.setSessionId(sITSessionId);  // Link item to the session
                item.setSessionItemId(sessionItemId);
                item.setSubItemId(subItemId);
                item.setCreatedBy(sITCreateBy);
                item.setCreatedDate(sITCreateDate);
                item.setModifiedBy(sITModifiedBy);
                item.setModifiedDate(sITModifiedDate);
                session.getSessionItemsJsonModels().add(item);
            }
        }
        return new ArrayList<>(cateringOrdersMap.values());
    }
}
