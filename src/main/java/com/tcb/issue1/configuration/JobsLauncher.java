package com.tcb.issue1.configuration;

import org.joda.time.LocalDateTime;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * This class is the job runner, it runs our job every 30 seconds.
 *
 * Created by Florian.Courtial on 05/02/16.
 */
@Component
public class JobsLauncher {

    @Autowired
    private Job carsToOffersJob;

    @Autowired
    private JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 30000)
    public void launch() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException,
            ExecutionException,
            InterruptedException, IOException {

        JobParameters jobParameters = new JobParametersBuilder()
            .addString("JOB_START_DATE", (new LocalDateTime()).toString())
            .toJobParameters();

        jobLauncher.run(carsToOffersJob, jobParameters);

    }
}
