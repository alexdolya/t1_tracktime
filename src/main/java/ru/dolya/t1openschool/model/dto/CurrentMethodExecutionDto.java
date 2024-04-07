package ru.dolya.t1openschool.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CurrentMethodExecutionDto {

    private String methodName;
    private long executionTime;
}
