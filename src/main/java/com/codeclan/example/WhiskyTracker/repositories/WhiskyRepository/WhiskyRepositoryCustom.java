package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    public List<Whisky> findWhiskiesByDistilleryAndAge(String distilleryName, int whiskyAge);

    public List<Whisky> findWhiskiesByRegion(String region);

}
