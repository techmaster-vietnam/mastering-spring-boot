package vn.techmaster.aop;

import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import vn.techmaster.aop.performance.PerformanceManager;

@Aspect
@Component
@AllArgsConstructor
public class PerformanceAspect {

    private final PerformanceManager performanceManager;

    @Around("execution(* vn.techmaster.aop.controller..*(..))")
    public Object measurePerformance(
        ProceedingJoinPoint joinPoint
    ) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        String methodName = joinPoint.getSignature().getName();
        performanceManager.record(methodName, elapsedTime);
        return result;
    }
}
