package com.mintic.appcomercio.repositories;

import com.mintic.appcomercio.models.ProductosModel;

import org.springframework.data.repository.CrudRepository;

public interface ProductosRepository extends CrudRepository<ProductosModel, Long> {

}
