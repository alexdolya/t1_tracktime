package ru.dolya.t1openschool.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.dolya.t1openschool.model.dto.CurrentMethodExecutionDto;
import ru.dolya.t1openschool.service.MethodExecutionStatisticsAsyncSaverService;

import java.util.concurrent.CompletableFuture;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class CommonTrackTimeAspect {

    private final MethodExecutionStatisticsAsyncSaverService methodExecutionStatisticsAsyncSaverService;

    @Around("@annotation(ru.dolya.t1openschool.annotation.TrackTime) " +
            "|| @annotation(ru.dolya.t1openschool.annotation.TrackAsyncTime)")
    public Object trackTime(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            long startTime = System.nanoTime();
            Object proceed = proceedingJoinPoint.proceed();
            long timeTaken = System.nanoTime() - startTime;
            CurrentMethodExecutionDto currentMethodExecutionDto = new CurrentMethodExecutionDto()
                    .setExecutionTime(timeTaken)
                    .setMethodName(proceedingJoinPoint.getSignature().getName());
            CompletableFuture.runAsync(() -> methodExecutionStatisticsAsyncSaverService.saveAsync(currentMethodExecutionDto));
            return proceed;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}