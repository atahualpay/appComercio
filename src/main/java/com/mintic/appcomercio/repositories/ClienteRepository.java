package com.mintic.appcomercio.repositories;

import com.mintic.appcomercio.models.ClienteModel;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {
    
}
