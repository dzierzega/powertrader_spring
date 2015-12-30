package com.powertrader.repository;

import com.powertrader.model.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dudus on 2015-11-28.
 */
public interface OfferRepository extends CrudRepository<Offer, Long> {

    List<Offer> findAll();
}