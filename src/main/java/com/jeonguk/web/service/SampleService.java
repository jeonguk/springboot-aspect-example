package com.jeonguk.web.service;

import org.springframework.stereotype.Service;

import com.jeonguk.web.model.Sample;

@Service
public class SampleService {
    
    public Sample createSample(String sampleName) {
        Sample sample = new Sample();
        sample.setName(sampleName);
        return sample;
    }
    
}