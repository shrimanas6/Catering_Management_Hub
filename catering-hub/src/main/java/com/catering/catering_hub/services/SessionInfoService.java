package com.catering.catering_hub.services;

import com.catering.catering_hub.models.CateringOrdersModel;
import com.catering.catering_hub.models.SessionItemsModel;
import com.catering.catering_hub.models.SessionsModel;
import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;
import com.catering.catering_hub.models.order_models.SessionsJsonModel;

import java.util.List;
import java.util.Optional;

public interface SessionInfoService {
    SessionsModel saveOrderSession(SessionsModel sessions);
    List<SessionsModel> saveSessionsList(List<SessionsModel> sessionsList);
    List<SessionItemsModel> saveSessionsJsonList(List<SessionsJsonModel> sessionsList);
    List<SessionsModel> getSessionInfoListById(String orderId);
}
