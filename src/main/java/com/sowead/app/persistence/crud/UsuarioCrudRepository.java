package com.sowead.app.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.sowead.app.persistence.entity.Usuario;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{
    
}
