package com.example.fiap.challenge.plusoft.service;

import com.example.fiap.challenge.plusoft.datasource.ClientRepository;
import com.example.fiap.challenge.plusoft.domainmodel.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repo;

    @Override
    @Transactional
    public Client save(Client c) {
        return this.repo.save(c);
    }

    @Override
    @Transactional
    public void delete(final Client c) {
        this.repo.delete(c);
    }

    @Override
    @Transactional
    public void deleteById(final long id) {
        this.repo.deleteById(id);
    }

    @Override
    @Transactional
    public List<Client> findAllClients() {
        return this.repo.findAll();
    }

    @Transactional
    public Optional<Client> findById(final long id) {
        return this.repo.findById(id);
    }
}
