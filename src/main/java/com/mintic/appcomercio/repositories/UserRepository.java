package com.mintic.appcomercio.repositories;

import com.mintic.appcomercio.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

 }