package com.example.fiap.challenge.plusoft.service;

import com.example.fiap.challenge.plusoft.datasource.CreditCardRepository;
import com.example.fiap.challenge.plusoft.domainmodel.CreditCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository repo;

    @Override
    @Transactional
    public CreditCard save(CreditCard cc) {
        return this.repo.save(cc);
    }

    @Override
    @Transactional
    public void delete(CreditCard cc) {
        this.repo.delete(cc);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional
    public List<CreditCard> findAllCards() {
        return this.repo.findAll();
    }

    @Transactional
    public Optional<CreditCard> findById(final long id) {
        return this.repo.findById(id);
    }
}
