package com.example.demo.controller;


import com.example.demo.service.OnTimeRequester;
import com.example.demo.service.TimingCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestTesting {

    TimingCalculatorService timingCalculatorService;

    public RestTesting(TimingCalculatorService timingCalculatorService) {
        this.timingCalculatorService = timingCalculatorService;
    }

    @GetMapping("/get/{locationFirst}/{locationSecond}")
    public String tryToGetSth(@PathVariable String locationFirst, @PathVariable String locationSecond) {
        return timingCalculatorService.calculateTravelTime(locationFirst, locationSecond);
    }

    @GetMapping("/getall")
    public Map<String, String> getAll() {
        return OnTimeRequester.getTiming();
    }
}

/**
 * Routing Car, Bicycle, Pedestrian
 * 0 to 30,000	Free
 * 30,001 to 5,000,000	€0.60
 * 5,000,001 to 10,000,000	€0.48
 */