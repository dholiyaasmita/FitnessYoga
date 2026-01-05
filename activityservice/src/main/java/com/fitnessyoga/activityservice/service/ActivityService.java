package com.fitnessyoga.activityservice.service;

import com.fitnessyoga.activityservice.ActivityRepository;
import com.fitnessyoga.activityservice.dto.ActivityRequest;
import com.fitnessyoga.activityservice.dto.ActivityResponse;
import com.fitnessyoga.activityservice.model.Activity;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        //console.log(activity);
        Activity saveedActivity = activityRepository.save(activity);
        return mapToResponse(saveedActivity);
    }

    private  ActivityResponse mapToResponse(Activity activity){
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(response.getStartTime());
        response.setAdditionalMetrics(response.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        System.out.println(response);
        return  response;

    }
}
