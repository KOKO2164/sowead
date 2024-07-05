package com.sowead.app.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.sowead.app.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

}
