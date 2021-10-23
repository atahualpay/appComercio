package com.mintic.appcomercio.repositories;

import org.springframework.data.repository.CrudRepository;
import com.mintic.appcomercio.models.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
}
