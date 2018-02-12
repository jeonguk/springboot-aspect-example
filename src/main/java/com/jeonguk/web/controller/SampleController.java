package com.jeonguk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jeonguk.web.model.Sample;
import com.jeonguk.web.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;
    
    @GetMapping("/sample/{sampleName}")
    public Sample sample(@PathVariable String sampleName) {
        log.info("sampleName = " + sampleName);
        return sampleService.createSample(sampleName);
    }
    
}