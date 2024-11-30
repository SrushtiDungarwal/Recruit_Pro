package com.jbk.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginTimeAspects {

	Logger logger = LoggerFactory.getLogger(LoginTimeAspects.class);
	
	@Around("execution (* com.jbk.controller.*.*(..))")
	public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		
		
		logger.info("Exection time = " + (endTime - startTime));
		
		return obj;
	}
}
