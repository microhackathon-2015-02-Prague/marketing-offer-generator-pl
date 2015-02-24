package com.ofg.marketingoffergenerator;

import com.ofg.marketingoffergenerator.model.ClientMarketingOffer;
import com.ofg.marketingoffergenerator.model.ClientMarketingOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartUp implements CommandLineRunner {

    @Autowired
    private ClientMarketingOfferRepository repository;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void run(String... args) throws Exception {
        ClientMarketingOffer offer = new ClientMarketingOffer();
        offer.setFirstName("Marek");
        offer.setLastName("Kurka");
        repository.persist(offer);
        System.out.println("ClientMarketingOffer saved");
        ClientMarketingOffer ent = repository.findByClient(offer.getFirstName(), offer.getLastName());
        System.out.println("ClientMarketingOffer loaded: " + ent);
    }
}
