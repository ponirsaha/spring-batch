package com.spring.batch.batch;

import com.spring.batch.repository.SlotCategoryRepository;
import com.spring.batch.repository.SlotPlanRepository;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class DataWriter implements Tasklet, StepExecutionListener {

    private final SlotPlanRepository slotPlanRepository;
    private final SlotCategoryRepository slotCategoryRepository;
    Long slotPlans;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        int result = 0;
        if (slotPlans > 0) {
          result =  slotPlanRepository.deleteData(76);
        }
        slotCategoryRepository.deleteCategory(4);
        log.info("Data Writer deleted data: {} items", result);
        return RepeatStatus.FINISHED;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();

        slotPlans = (Long) executionContext.get("slotPlans");
        log.info("Data Writer initialized.");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.debug("Data Writer ended.");
        return ExitStatus.COMPLETED;
    }
}
