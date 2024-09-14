package com.example.fiap.challenge.plusoft.service;

import com.example.fiap.challenge.plusoft.domainmodel.Client;

import java.util.List;

public interface ClientService {

    Client save(Client c);

    void delete(Client c);

    void deleteById(long id);

    List<Client> findAllClients();
}
