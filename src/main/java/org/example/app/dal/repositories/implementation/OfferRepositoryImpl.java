package org.example.app.dal.repositories.implementation;

import org.example.app.dal.config.util.EntityManagerUtil;
import org.example.app.dal.entities.Offer;
import org.example.app.dal.repositories.interfaces.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class OfferRepositoryImpl extends BaseRepository<Offer, UUID> implements OfferRepository {
    public OfferRepositoryImpl(@Autowired EntityManagerUtil entityManagerUtil) {
        super(entityManagerUtil);
    }
}
