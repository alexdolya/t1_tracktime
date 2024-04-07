package ru.dolya.t1openschool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.dolya.t1openschool.service.TestMethodService;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class T1OpenSchoolApplication {

    private final TestMethodService testMethodService;

    public static void main(String[] args) {
        SpringApplication.run(T1OpenSchoolApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {

        log.info("Запуск выполнения 10 методов с аннотацией @TrackTime.");
        for (int i = 1; i <= 10; i++) {
            testMethodService.testMethodWithTrackTimeAnnotation(i);
        }

        log.info("Запуск выполнения 50 методов с аннотацией @TrackAsyncTime.");
        for (int i = 1; i <= 50; i++) {
            testMethodService.testMethodWithTrackTimeAsyncAnnotation(i);
        }

    }

}
