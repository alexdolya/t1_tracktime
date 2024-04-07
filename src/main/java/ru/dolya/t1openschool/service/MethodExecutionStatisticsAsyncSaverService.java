package ru.dolya.t1openschool.service;

import ru.dolya.t1openschool.model.dto.CurrentMethodExecutionDto;

public interface MethodExecutionStatisticsAsyncSaverService {
    void saveAsync(CurrentMethodExecutionDto currentMethodExecutionDto);
}
