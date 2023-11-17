package com.spring.batch.batch;

import com.spring.batch.repository.SlotPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
@RequiredArgsConstructor
public class DataReader implements Tasklet, StepExecutionListener {
    private final SlotPlanRepository slotPlanRepository;
    Long slotPlans;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        slotPlans = slotPlanRepository.fetchAllRecords();
        log.info("Record found: {}", slotPlans );

        return RepeatStatus.FINISHED;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

        log.info("Before reading list is initialized");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution.getJobExecution()
                .getExecutionContext()
                .put("slotPlans", slotPlans);
        log.debug("Data Reader ended.");
        return ExitStatus.COMPLETED;
    }
}