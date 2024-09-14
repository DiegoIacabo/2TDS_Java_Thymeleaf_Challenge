package com.example.fiap.challenge.plusoft.datasource;

import com.example.fiap.challenge.plusoft.domainmodel.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
