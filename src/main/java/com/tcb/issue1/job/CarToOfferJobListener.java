package com.tcb.issue1.job;

import com.tcb.issue1.model.Car;
import com.tcb.issue1.repository.CarRepository;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class is the job listener for our Car to Offer job. It is useful to insert some data before to
 * run the job (cars in our case).
 *
 * Created by Florian.Courtial on 13/02/16.
 */
@Component
public class CarToOfferJobListener extends JobExecutionListenerSupport {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {

        carRepository.save(new Car("1", "Ford Escort", 128000, 10));
        carRepository.save(new Car("2", "Opel Corsa", 23000, 3));
        carRepository.save(new Car("3", "Renault Clio", 290000, 16));
        carRepository.save(new Car("4", "Peugeot 206", 1000, 8));
        carRepository.save(new Car("5", "Peugeot 107", 95000, 6));

    }

}
