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
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        roles.setRoleId(maxId != 0 ? (maxId+1) : 1);
        return roleRepo.save(roles);
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
