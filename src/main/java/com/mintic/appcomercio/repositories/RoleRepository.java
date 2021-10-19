package com.mintic.appcomercio.repositories;

import com.mintic.appcomercio.models.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}