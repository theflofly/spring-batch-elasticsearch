package com.tcb.issue1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * This class represents an offer (a car to sell).
 *
 * Created by Florian.Courtial on 11/01/16.
 */
@Document(indexName="issue1", type="offer")
public class Offer {

    @Id
    private String id;

    @Field(type = FieldType.String)
    private String model;

    @Field(type = FieldType.Integer)
    private int milesNumber;

    @Field(type = FieldType.Integer)
    private int age;

    @Field(type = FieldType.Integer)
    private int price;
}
