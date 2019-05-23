package com.mightyjava.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Pointcut("execution(* com.mightyjava.*.*.*(..))")
	private void generalPointcut() {

	}
	
	@AfterThrowing(pointcut="generalPointcut() throws Exception", throwing="ex")
	public void exceptionLog(JoinPoint joinPoint, Exception ex) throws Exception {
		logger.error(joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName()
					+" : "+ex.getMessage());
	}

	@Before("generalPointcut()")
	public void infoLog(JoinPoint joinPoint) {
		logger.info(joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName());
	}
}
