package com.tcb.issue1.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by fco on 05/02/16.
 */
@Component
public class JobsLauncher {

    @Autowired
    private Job carsToOffersJob;

    @Autowired
    private JobsLauncher jobLauncher;

    @Scheduled(fixedDelay = 10000000)
    public void launch() throws JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException,
            ExecutionException,
            InterruptedException, IOException {

        jobLauncher.run(carsToOffersJob);

    }
}
