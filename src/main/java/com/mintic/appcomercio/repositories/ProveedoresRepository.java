package com.mintic.appcomercio.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mintic.appcomercio.models.ProveedoresModel;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedoresModel, Integer>{
	
	 	
}
