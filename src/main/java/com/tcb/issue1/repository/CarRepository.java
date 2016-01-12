package com.tcb.issue1.repository;

import com.tcb.issue1.model.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * This class is a repository for the car object model. It abstract the data access by providing default methods to
 * access data.
 *
 * Created by Florian.Courtial on 11/01/16.
 */
public interface CarRepository extends ElasticsearchRepository<Car,String> {
}
