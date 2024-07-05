package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.Client;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClient(int clientId);
    Client save(Client client);
    void delete(int clientId);
}
