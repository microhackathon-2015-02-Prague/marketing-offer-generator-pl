package com.ofg.marketingoffergenerator.model;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientMarketingOfferRepositoryBean extends AbstractRepository<ClientMarketingOffer, Long> implements ClientMarketingOfferRepository  {
    public ClientMarketingOfferRepositoryBean() {
        super(ClientMarketingOffer.class);
    }

    @Override
    public ClientMarketingOffer findByClient(String firstName, String lastName) {
        Criteria criteria = session().createCriteria(ClientMarketingOffer.class);
        criteria.add(Restrictions.eq("firstName", firstName));
        criteria.add(Restrictions.eq("lastName", lastName));
        return (ClientMarketingOffer) criteria.uniqueResult();

    }
}
