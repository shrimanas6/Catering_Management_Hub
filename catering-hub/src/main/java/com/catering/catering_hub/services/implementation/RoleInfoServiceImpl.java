package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.RoleInfoModel;
import com.catering.catering_hub.repository.RoleInfoRepo;
import com.catering.catering_hub.services.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoRepo roleRepo;


    @Override
    public RoleInfoModel saveRoleInfo(RoleInfoModel roles) {
        int roleId = roles.getRoleId() != null ? roles.getRoleId() : 0;
        int maxId = roleId > 0 ? roleId : findMaxId() != null ? findMaxId().intValue() : 0;
        roles.setRoleId(roleId > 0 ? roleId : maxId != 0 ? (maxId+1) : 1);
        return roleRepo.save(roles);
    }

    @Override
    public List<RoleInfoModel> getRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<RoleInfoModel> getRoleById(Integer roleId) {
        return roleRepo.findById(roleId);
    }

    @Override
    public String deleteRoleById(Integer roleId) {
        roleRepo.deleteById(roleId);
        return "Role Info Deleted Successfully";
    }

    @Override
    public String deleteRoles() {
        roleRepo.deleteAll();
        return "All Roles Deleted Successfully";
    }

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = roleRepo.findAllRoleIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
