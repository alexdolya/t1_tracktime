package ru.dolya.t1openschool.service;

import org.springframework.transaction.annotation.Transactional;
import ru.dolya.t1openschool.model.dto.CurrentMethodExecutionDto;
import ru.dolya.t1openschool.model.dto.MethodExecutionStatisticsDto;

import java.util.List;

public interface MethodExecutionStatisticsService {

    List<MethodExecutionStatisticsDto> findAll();

    MethodExecutionStatisticsDto findByMethodName(String methodName);

    @Transactional
    void calculateAndSave(CurrentMethodExecutionDto currentMethodExecutionDto);
}
