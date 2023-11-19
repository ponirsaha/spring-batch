package com.spring.batch;

import com.spring.batch.config.BatchConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BatchConfig.class)
public class MockBatchConfig {
}
