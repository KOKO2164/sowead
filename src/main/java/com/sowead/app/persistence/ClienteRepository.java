package com.sowead.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowead.app.domain.Client;
import com.sowead.app.domain.repository.ClientRepository;
import com.sowead.app.persistence.crud.ClienteCrudRepository;
import com.sowead.app.persistence.entity.Cliente;
import com.sowead.app.persistence.mapper.ClientMapper;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClient(int clientId) {
        return clienteCrudRepository.findById(clientId).map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(int clientId) {
        clienteCrudRepository.deleteById(clientId);
    }
}
