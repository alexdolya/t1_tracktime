package ru.dolya.t1openschool.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "method_execution_statistics")
@Accessors(chain = true)
public class MethodExecutionStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "count_of_calls")
    private int countOfCalls;

    @Column(name = "last_call_date_time")
    private LocalDateTime lastCallDateTime;

    @Column(name = "last_execution_time")
    private long lastExecutionTime;

    @Column(name = "avg_execution_time")
    private long avgExecutionTime;

}