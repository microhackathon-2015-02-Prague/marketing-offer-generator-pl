package com.ofg.marketingoffergenerator.model;

public interface ClientMarketingOfferRepository {
    Long persist(ClientMarketingOffer entity);

    ClientMarketingOffer findByClient(String firstName, String lastName);

}

