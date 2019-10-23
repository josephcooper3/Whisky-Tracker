package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/distilleries")
    @ResponseBody
    public List<Whisky> findWhiskiesByDistilleryAndAge(@RequestParam String name, int age) {
        return whiskyRepository.findWhiskiesByDistilleryAndAge(name, age);
    }

    @GetMapping(value = "/regions")
    @ResponseBody
    public List<Whisky> findWhiskiesByRegion(@RequestParam String region) {
        return whiskyRepository.findWhiskiesByRegion(region);
    }

}
