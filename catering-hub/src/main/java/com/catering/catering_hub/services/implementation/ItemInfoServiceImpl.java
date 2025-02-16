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
        int itemId = item.getItemId() != null ? item.getItemId() : 0;
        int maxId = itemId > 0 ? itemId : findMaxId() != null ? findMaxId().intValue() : 0;
        item.setItemId(itemId > 0 ? itemId : maxId != 0 ? (maxId+1) : 1);
        return itemRepo.save(item);
    }

    @Override
    public List<ItemMasterModel> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public String deleteItemsById(Integer itemId) {
        itemRepo.deleteById(itemId);
        return "Item Info Deleted Successfully";
    }

    @Override
    public String deleteAllItems() {
        itemRepo.deleteAll();
        return "All Items Deleted Successfully";
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
