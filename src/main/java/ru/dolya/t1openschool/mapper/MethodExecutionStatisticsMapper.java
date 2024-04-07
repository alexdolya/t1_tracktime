package ru.dolya.t1openschool.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dolya.t1openschool.model.dto.MethodExecutionStatisticsDto;
import ru.dolya.t1openschool.model.entity.MethodExecutionStatistics;

@Mapper
public interface MethodExecutionStatisticsMapper {
    MethodExecutionStatisticsMapper INSTANCE = Mappers.getMapper(MethodExecutionStatisticsMapper.class);

    MethodExecutionStatisticsDto MethodExecutionStatisticsToDto(MethodExecutionStatistics methodExecutionStatistics);
}
