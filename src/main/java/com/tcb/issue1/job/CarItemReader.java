package com.tcb.issue1.job;

import com.tcb.issue1.model.Car;
import com.tcb.issue1.repository.CarRepository;
import org.springframework.batch.item.data.AbstractPaginatedDataItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import static org.springframework.util.ClassUtils.getShortName;

/**
 * This class is the item reader for the car object. It reads cars from the elasticsearch database
 * and returns them. The doPageRead method is called several times until it returns null.
 *
 * Created by Florian.Courtial on 11/01/16.
 */
@Component
public class CarItemReader extends AbstractPaginatedDataItemReader<Car> implements InitializingBean {

    private Pageable carPageable;

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    public void init() {
        setName(getShortName(getClass()));
        // by default 100 cars are returned on each call
        this.carPageable = new PageRequest(0,100);
    }

    @Override
    protected Iterator<Car> doPageRead() {

        Page<Car> cars = carRepository.findAll(this.carPageable);
        carPageable = carPageable.next();
        return cars.iterator();

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
