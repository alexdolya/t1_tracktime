package ru.dolya.t1openschool.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dolya.t1openschool.model.dto.CurrentMethodExecutionDto;
import ru.dolya.t1openschool.service.MethodExecutionStatisticsAsyncSaverService;
import ru.dolya.t1openschool.service.MethodExecutionStatisticsService;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@AllArgsConstructor
public class MethodExecutionStatisticsAsyncAsyncSaverServiceImpl implements MethodExecutionStatisticsAsyncSaverService {

    private final BlockingQueue<CurrentMethodExecutionDto> queue = new LinkedBlockingQueue<>();

    private final MethodExecutionStatisticsService methodExecutionStatisticsService;


    @PostConstruct
    public void init() {
        CompletableFuture.runAsync(this::waitAndSave);
    }

    @Override
    public void saveAsync(CurrentMethodExecutionDto currentMethodExecutionDto) {
        try {
            queue.put(currentMethodExecutionDto);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void waitAndSave() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                CurrentMethodExecutionDto take = queue.take();
                methodExecutionStatisticsService.calculateAndSave(take);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
