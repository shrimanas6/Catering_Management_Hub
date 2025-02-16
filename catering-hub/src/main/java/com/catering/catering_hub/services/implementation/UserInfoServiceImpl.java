package com.catering.catering_hub.services.implementation;

import com.catering.catering_hub.models.UserInfoModel;
import com.catering.catering_hub.repository.UserInfoRepo;
import com.catering.catering_hub.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepo userRepo;

    @Override
    public UserInfoModel saveUserInfo(UserInfoModel user) {
        int userId = user.getUserId() != null ? user.getUserId() : 0;
        int maxId = userId > 0 ? userId : findMaxId() != null ? findMaxId().intValue() : 0;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateString = dateFormat.format(currentDate);

        user.setUserId(userId > 0 ? userId : maxId != 0 ? (maxId+1) : 1);
        user.setCreatedDate(formattedDateString);
        return userRepo.save(user);
    }

    @Override
    public List<UserInfoModel> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserInfoModel> getUserById(Integer userId) {
        return userRepo.findById(userId);
    }

    @Override
    public String deleteUserById(Integer userId) {
        userRepo.deleteById(userId);
        return "User Info Deleted Successfully";
    }

    @Override
    public String deleteAllUsers() {
        userRepo.deleteAll();
        return "All Users Deleted Successfully";
    }

    public Long findMaxId() {
        // Fetch all IDs from the repository
        List<Long> ids = userRepo.findAllUserIdsUsingNativeQuery();

        // Use Streams to find the maximum ID
        Optional<Long> maxId = ids.stream().max(Long::compareTo);

        // Return the max ID, or handle empty list case
        return maxId.orElse(null);  // Or throw exception if needed
    }
}
