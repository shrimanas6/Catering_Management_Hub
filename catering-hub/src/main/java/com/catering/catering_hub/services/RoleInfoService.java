package com.catering.catering_hub.services;

import com.catering.catering_hub.models.RoleInfoModel;

import java.util.List;
import java.util.Optional;

public interface RoleInfoService {

    RoleInfoModel saveRoleInfo(RoleInfoModel roles);
    List<RoleInfoModel> getRoles();
    Optional<RoleInfoModel> getRoleById(Integer roleId);
    String deleteRoleById(Integer roleId);
    String deleteRoles();
}
