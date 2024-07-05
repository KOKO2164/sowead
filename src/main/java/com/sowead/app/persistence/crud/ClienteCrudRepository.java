package com.sowead.app.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.sowead.app.persistence.entity.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer>{
    
}
