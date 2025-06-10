package com.catering.catering_hub.services;

import com.catering.catering_hub.models.UserInfoModel;
import com.catering.catering_hub.models.order_models.UserInfoJsonModel;

import java.util.List;
import java.util.Optional;

public interface UserInfoService {

    UserInfoModel saveUserInfo(UserInfoJsonModel user);
    List<UserInfoModel> getUsers();
    Optional<UserInfoModel> getUserById(Integer userId);
    String deleteUserById(Integer userId);
    String deleteAllUsers();
    UserInfoModel loginValidator(UserInfoJsonModel loginInfo);
}
