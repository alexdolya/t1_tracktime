package ru.dolya.t1openschool.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import ru.dolya.t1openschool.annotation.TrackAsyncTime;
import ru.dolya.t1openschool.annotation.TrackTime;
import ru.dolya.t1openschool.service.TestMethodService;

@Service
@Slf4j
@EnableAsync
public class TestMethodServiceImpl implements TestMethodService {

    @Override
    @TrackTime
    public void testMethodWithTrackTimeAnnotation(int numOfCall) {
        try {
            log.info("Старт выполнения синхронного метода №{}", numOfCall);
            Thread.sleep(1000);
            log.info("Конец выполнения синхронного метода №{}", numOfCall);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении метода \"testMethodWithTrackTimeAnnotation\". ", e);
        }
    }

    @Override
    @TrackAsyncTime
    public void testMethodWithTrackTimeAsyncAnnotation(int numOfCall) {
        try {
            log.info("Старт выполнения асинхронного метода №{}", numOfCall);
            Thread.sleep(1000);
            log.info("Конец выполнения асинхронного метода №{}", numOfCall);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении метода \"testMethodWithTrackTimeAsyncAnnotation\". ", e);
        }
    }

}
