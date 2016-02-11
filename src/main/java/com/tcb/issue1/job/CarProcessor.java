package com.tcb.issue1.job;

import com.tcb.issue1.model.Car;
import com.tcb.issue1.model.Offer;
import org.slf4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * This class is a processor, it takes a Car as parameter then returns an Offer.
 *
 * Created by Florian.Courtial on 27/01/16.
 */
public class CarProcessor implements ItemProcessor<Car, Offer> {

    private Logger logger = getLogger(getClass());

    @Override
    public Offer process(Car car) throws Exception {

        Offer offer = new Offer();

        offer.setId(car.getId());
        offer.setAge(car.getAge());
        offer.setMilesNumber(car.getMilesNumber());
        offer.setModel(car.getModel());
        offer.setPrice(car.getAge() * 100000 - car.getMilesNumber());

        logger.info("Converting : " + car.toString() + " to " + offer.toString());

        return offer;
    }

}
