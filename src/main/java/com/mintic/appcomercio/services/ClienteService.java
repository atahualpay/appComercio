package com.mintic.appcomercio.services;

import java.util.ArrayList;
import java.util.Optional;

import com.mintic.appcomercio.models.ClienteModel;
import com.mintic.appcomercio.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Establece la clase como servidor
public class ClienteService { // Metodos a utilizar en la logica

    @Autowired // Inicializa correctamente el objeto
    ClienteRepository clienteRepository; // Declara un nuevo objeto para el manejo de CRUD

    public ClienteModel guardarCliente(ClienteModel cliente) { // Metodo para guardar cliente en tabla
        return clienteRepository.save(cliente); // Sentencia para guardar el cliente
    }

    public Long contarClientes() {
        return clienteRepository.count();
    }

    public Optional<ClienteModel> obtenerPorCedula(Long cedula_cliente) { // Optional ayuda con el manejo de resultados
                                                                          // null
        return clienteRepository.findById(cedula_cliente);
    }

    public ArrayList<ClienteModel> obtenerClientes() {
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public boolean eliminarCliente(Long cedula_cliente) {
        try {
            clienteRepository.deleteById(cedula_cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
