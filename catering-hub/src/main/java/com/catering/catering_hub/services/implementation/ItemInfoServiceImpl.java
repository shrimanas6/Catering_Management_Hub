package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.ItemMasterModel;
import com.catering.catering_hub.repository.ItemInfoRepo;
import com.catering.catering_hub.services.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemInfoServiceImpl implements ItemInfoService {

    @Autowired
    private ItemInfoRepo itemRepo;

    @Override
    public ItemMasterModel saveItemInfo(ItemMasterModel item) {
        int maxId = findMaxId() != null ? findMaxId().intValue() : 0;
        item.setItemId(maxId != 0 ? (maxId+1) : 1);
        return itemRepo.save(item);
    }


    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = itemRepo.findAllItemIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
