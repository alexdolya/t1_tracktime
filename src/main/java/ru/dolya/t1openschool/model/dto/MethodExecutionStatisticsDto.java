package ru.dolya.t1openschool.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MethodExecutionStatisticsDto {

    private String methodName;
    private int countOfCalls;
    private LocalDateTime lastCallDateTime;
    private long lastExecutionTime;
    private double avgExecutionTime;
}
