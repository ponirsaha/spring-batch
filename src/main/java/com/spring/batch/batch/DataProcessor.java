package com.spring.batch.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;


@Slf4j
public class DataProcessor implements Tasklet, StepExecutionListener {

    Long slotPlans;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {

        return RepeatStatus.FINISHED;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution.getJobExecution().getExecutionContext();

        slotPlans = (Long) executionContext.get("slotPlans");
        log.debug("Data Processor initialized.");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.debug("Data Processor ended.");
        return ExitStatus.COMPLETED;
    }
}
