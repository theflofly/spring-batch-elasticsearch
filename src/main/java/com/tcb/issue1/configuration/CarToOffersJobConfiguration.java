package com.tcb.issue1.configuration;

import com.tcb.issue1.job.CarToOfferJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This class is the configuration class for our CarToOffer job.
 *
 * @author floriancourtial@gmail.com
 */
@Configuration
@EnableBatchProcessing
@EnableScheduling
public class CarToOffersJobConfiguration {

    @Bean
    public Job carsToOffersJob(JobBuilderFactory jobs, Step createOffersStep, CarToOfferJobListener carToOfferJobListener) {
        return jobs.get("carsToOffersJob")
                .incrementer(new RunIdIncrementer())
                .listener(carToOfferJobListener)
                .flow(createOffersStep)
                .end()
                .build();
    }

}
