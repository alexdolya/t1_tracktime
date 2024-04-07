package ru.dolya.t1openschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dolya.t1openschool.model.entity.MethodExecutionStatistics;

@Repository
public interface MethodExecutionStatisticsRepository extends JpaRepository<MethodExecutionStatistics, Long> {

    @Query("SELECT m FROM MethodExecutionStatistics m WHERE m.methodName = :methodName")
    MethodExecutionStatistics findByMethodName(String methodName);

}
