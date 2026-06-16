package com.example.hcmk24cntt1nguyendaiphat002.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class LoggerMethod {

    @Before("execution(*com.example.hcmk24cntt1nguyendaiphat002..*(..))")
    public void loggerMethod(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();

        log.info("methou " + nameMethod);
    }
}
