package com.usa.finance.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class Scheduler {

    private final JobLauncher jobLauncher;

    private final Job syncBithumbJob;

    private void job
}
