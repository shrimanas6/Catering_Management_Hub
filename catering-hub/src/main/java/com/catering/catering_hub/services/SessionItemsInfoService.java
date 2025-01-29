package com.catering.catering_hub.services;

import com.catering.catering_hub.models.SessionItemsModel;

import java.util.List;

public interface SessionItemsInfoService {
    SessionItemsModel saveSessionItemsInfo(SessionItemsModel sessionItems);
    void saveSessionItemsInfoList(SessionItemsModel sessionItems);
    void saveSessionItemsFilteredInfo(List<SessionItemsModel> sessionItemsList);
    List<SessionItemsModel>  saveOrderItemsList();
}
