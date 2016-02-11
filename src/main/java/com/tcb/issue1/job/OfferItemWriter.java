package com.tcb.issue1.job;

import com.tcb.issue1.model.Offer;
import com.tcb.issue1.repository.OfferRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * This class is the writer for the Offer object, it writes a list of Offers into the Elasticsearch database.
 *
 * Created by Florian.Courtial on 28/01/16.
 */
public class OfferItemWriter implements ItemWriter<Offer>, InitializingBean {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public void afterPropertiesSet() throws Exception {}

    @Override
    public void write(List<? extends Offer> list) throws Exception {
        offerRepository.save(list);
    }

}
