package ru.dolya.t1openschool.service.impl;

import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dolya.t1openschool.mapper.MethodExecutionStatisticsMapper;
import ru.dolya.t1openschool.model.dto.CurrentMethodExecutionDto;
import ru.dolya.t1openschool.model.dto.MethodExecutionStatisticsDto;
import ru.dolya.t1openschool.model.entity.MethodExecutionStatistics;
import ru.dolya.t1openschool.repository.MethodExecutionStatisticsRepository;
import ru.dolya.t1openschool.service.MethodExecutionStatisticsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MethodExecutionStatisticsServiceImpl implements MethodExecutionStatisticsService {

    private final MethodExecutionStatisticsRepository methodExecutionStatisticsRepository;

    @Override
    public List<MethodExecutionStatisticsDto> findAll() {
        return methodExecutionStatisticsRepository.findAll().stream()
                .map(MethodExecutionStatisticsMapper.INSTANCE::MethodExecutionStatisticsToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MethodExecutionStatisticsDto findByMethodName(String methodName) {
        MethodExecutionStatistics methodExecutionStatistics = methodExecutionStatisticsRepository.findByMethodName(methodName);
        return MethodExecutionStatisticsMapper.INSTANCE.MethodExecutionStatisticsToDto(methodExecutionStatistics);
    }

    @Override
    @Transactional
    @Lock(LockModeType.WRITE)
    public void calculateAndSave(CurrentMethodExecutionDto currentMethodExecutionDto) {
        MethodExecutionStatistics methodExecutionStatistics = methodExecutionStatisticsRepository.findByMethodName(currentMethodExecutionDto.getMethodName());
        if (methodExecutionStatistics == null) {
            methodExecutionStatistics = new MethodExecutionStatistics()
                    .setMethodName(currentMethodExecutionDto.getMethodName())
                    .setCountOfCalls(1)
                    .setLastCallDateTime(LocalDateTime.now())
                    .setLastExecutionTime(currentMethodExecutionDto.getExecutionTime())
                    .setAvgExecutionTime(currentMethodExecutionDto.getExecutionTime());
            methodExecutionStatisticsRepository.save(methodExecutionStatistics);
        } else {
            int countOfCalls = methodExecutionStatistics.getCountOfCalls() + 1;
            methodExecutionStatistics.setCountOfCalls(countOfCalls);
            methodExecutionStatistics.setLastCallDateTime(LocalDateTime.now());
            methodExecutionStatistics.setLastExecutionTime(currentMethodExecutionDto.getExecutionTime());
            long avgExecutionTime = (methodExecutionStatistics.getAvgExecutionTime() + currentMethodExecutionDto.getExecutionTime()) / 2;
            methodExecutionStatistics.setAvgExecutionTime(avgExecutionTime);
            methodExecutionStatisticsRepository.save(methodExecutionStatistics);
        }
    }

}
