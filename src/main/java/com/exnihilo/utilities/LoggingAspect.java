package com.exnihilo.utilities;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Around("execution(* com.exnihilo.services.impl..*.*(..))")
    public Object logServiceMethod(@NonNull ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();

        if (!(signature instanceof MethodSignature methodSignature)) {
            throw new IllegalArgumentException("This advice can only be used with methods.");
        }

        String methodName = methodSignature.getName();
        String className = methodSignature.getDeclaringTypeName();
        Object[] methodArgs = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();

        log.info("Entering method: {}.{} with arguments: {}", className, methodName, Arrays.toString(methodArgs));

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        log.info("Exiting method: {}.{}. Execution time: {} ms", className, methodName, executionTime);

        return result;
    }
}
