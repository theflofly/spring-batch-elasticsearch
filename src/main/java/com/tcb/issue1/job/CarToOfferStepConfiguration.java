package com.tcb.issue1.job;

import com.tcb.issue1.model.Car;
import com.tcb.issue1.model.Offer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is the configuration for the "createOffers" step. It puts together the reader,
 * the processor and the writer.
 *
 * Created by Florian.Courtial on 28/01/16.
 */
@Configuration
@EnableBatchProcessing
public class CarToOfferStepConfiguration {

    @Bean
    public Step createOffersStep(
            StepBuilderFactory stepBuilderFactory,
            @Qualifier("carReader") ItemReader<Car> carReader,
            @Qualifier("carProcessor") ItemProcessor<Car,Offer> carProcessor,
            @Qualifier("offerWriter") OfferItemWriter offerWriter) {

        return stepBuilderFactory.get("createOffersStep")
                .<Car, Offer> chunk(10)
                .reader(carReader)
                .processor(carProcessor)
                .writer(offerWriter)
                .build();
    }

    @Bean(name = "carReader")
    public ItemReader<Car> carReader() {
        return new CarItemReader();
    }

    @Bean(name = "carProcessor")
    public ItemProcessor<Car, Offer> carProcessor() {
        return new CarProcessor();
    }

    @Bean(name = "offerWriter")
    public OfferItemWriter offerWriter() {
        return new OfferItemWriter();
    }


}
