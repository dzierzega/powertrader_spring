package com.powertrader.web;

import com.powertrader.model.Offer;
import com.powertrader.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;

    @RequestMapping("/{id}")
    public Offer home(@PathVariable Long id) {
        Offer offer = offerRepository.findOne(id);
        return offer;
    }

    @RequestMapping("/")
    public List<Offer> offerList() {
        return offerRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Offer saveOffer(@RequestBody Offer offer) {
        offer.setId(null);
        offerRepository.save(offer);
        return offer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    String deleteOffer(@PathVariable Long id) {
        Offer offer = offerRepository.findOne(id);
        offer.setDeleted(true);
        offerRepository.save(offer);
        return "Offer has been deleted";
    }

}
