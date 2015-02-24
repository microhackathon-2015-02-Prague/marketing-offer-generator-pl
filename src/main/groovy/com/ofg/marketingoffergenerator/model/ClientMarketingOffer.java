package com.ofg.marketingoffergenerator.model;

import javax.persistence.*;

@Entity
public class ClientMarketingOffer {

    @Id
    @GeneratedValue(generator = "client_marketing_offer_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "client_marketing_offer_seq", sequenceName = "client_marketing_offer_seq", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private String marketingOffer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMarketingOffer() {
        return marketingOffer;
    }

    public void setMarketingOffer(String marketingOffer) {
        this.marketingOffer = marketingOffer;
    }
}
