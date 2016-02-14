package com.tcb.issue1.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * This class represents a car.
 *
 * Created by Florian.Courtial on 11/01/16.
 */
@Data
@Document(indexName="db", type="car")
public class Car {

    @Id
    private String id;

    @Field(type = FieldType.String)
    private String model;

    @Field(type = FieldType.Integer)
    private int milesNumber;

    @Field(type = FieldType.Integer)
    private int age;

    public Car(String id, String model, int milesNumber, int age) {
        this.id = id;
        this.model = model;
        this.milesNumber = milesNumber;
        this.age = age;
    }

    public Car() {}
}
