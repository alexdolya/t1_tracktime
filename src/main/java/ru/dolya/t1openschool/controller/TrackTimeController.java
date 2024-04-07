package ru.dolya.t1openschool.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dolya.t1openschool.model.dto.MethodExecutionStatisticsDto;
import ru.dolya.t1openschool.service.MethodExecutionStatisticsService;
import ru.dolya.t1openschool.service.TestMethodService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrackTimeController {

    private final MethodExecutionStatisticsService methodExecutionStatisticsService;
    private final TestMethodService testMethodService;


    @Operation(summary = "Получить статистику по всем ранее запущенным методам.")
    @GetMapping("/findAll")
    public List<MethodExecutionStatisticsDto> findByAll() {
        return methodExecutionStatisticsService.findAll();
    }

    @Operation(summary = "Получить статистику метода по имени.")
    @GetMapping("/find/{methodName}")
    public MethodExecutionStatisticsDto findByName(@PathVariable String methodName) {
        return methodExecutionStatisticsService.findByMethodName(methodName);
    }

    @Operation(summary = "Вызвать синхронный метод.")
    @PostMapping("/runSync")
    public void runSync() {
        testMethodService.testMethodWithTrackTimeAnnotation(1);
    }

    @Operation(summary = "Вызвать асинхронный метод.")
    @PostMapping("/runAsync")
    public void runAsync() {
        testMethodService.testMethodWithTrackTimeAsyncAnnotation(1);
    }

    @Operation(summary = "Вызвать синхронный метод N раз.")
    @PostMapping("/runSync/{countOfCalls}")
    public void runSyncNTimes(@Positive @PathVariable Integer countOfCalls) {
        for (int i = 1; i <= countOfCalls; i++) {
            testMethodService.testMethodWithTrackTimeAnnotation(i);
        }
    }

    @Operation(summary = "Вызвать асинхронный метод N раз.")
    @PostMapping("/runAsync/{countOfCalls}")
    public void runAsyncNTimes(@Positive @PathVariable Integer countOfCalls) {
        for (int i = 1; i <= countOfCalls; i++) {
            testMethodService.testMethodWithTrackTimeAsyncAnnotation(i);
        }
    }

}
