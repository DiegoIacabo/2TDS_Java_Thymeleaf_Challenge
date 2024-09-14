package com.example.fiap.challenge.plusoft.service;

import com.example.fiap.challenge.plusoft.domainmodel.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard save(CreditCard cc);

    void delete(CreditCard cc);

    void deleteById(long id);

    List<CreditCard> findAllCards();
}
