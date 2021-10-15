package com.mintic.appcomercio.services;

import java.util.ArrayList;
import java.util.Optional;

import com.mintic.appcomercio.models.UsuarioModel;
import com.mintic.appcomercio.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //Establece la clase como servidor
public class UsuarioService {

    @Autowired  //Inicializa correctamente el objeto
    UsuarioRepository usuarioRepository;    //Declara un nuevo objeto para el manejo de CRUD
    
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {  //Metodo para guardar cliente en tabla
        return usuarioRepository.save(usuario); //Sentencia para guardar el cliente
    }

    public Optional<UsuarioModel> obtenerPorCedula(Long cedula_usuario) {  //Optional ayuda con el manejo de resultados null
        return usuarioRepository.findById(cedula_usuario);
    }

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public boolean eliminarUsuario(Long cedula_usuario) {
        try {
            usuarioRepository.deleteById(cedula_usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
