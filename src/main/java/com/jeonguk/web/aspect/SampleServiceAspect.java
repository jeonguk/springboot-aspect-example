package com.jeonguk.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jeonguk.web.model.Sample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class SampleServiceAspect {

    @Before("execution(* com.jeonguk.web.service.SampleService.createSample (java.lang.String)) && args(sampleName)")
    public void beforeSampleCreation(String sampleName) {
        log.info("A request was issued for a sample name: "+sampleName);
    }
    
    @Around("execution(* com.jeonguk.web.service.SampleService.createSample (java.lang.String)) && args(sampleName)")
    public Object aroundSampleCreation(ProceedingJoinPoint proceedingJoinPoint, String sampleName) throws Throwable {
        log.info("A request was issued for a sample name: " + sampleName);
        sampleName = sampleName + "!";
        
        Sample sample = (Sample) proceedingJoinPoint.proceed(new Object[] {sampleName});
        sample.setName(sample.getName().toUpperCase());
        
        return sample;
    }

}