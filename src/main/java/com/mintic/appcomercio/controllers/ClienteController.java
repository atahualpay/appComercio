package com.mintic.appcomercio.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.mintic.appcomercio.models.ClienteModel;
import com.mintic.appcomercio.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Declara la clase como controlador
@RequestMapping("/clientes") // Define la direccion del controlador
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping //Solicitud por pagina
    public ArrayList<ClienteModel> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @PostMapping    //Update de datos
    public ClienteModel crearModificarCliente(@RequestBody ClienteModel cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping(path = "{cedula_ciente}")
    public Optional<ClienteModel> obtenerPorCedula(@PathVariable("cedula_ciente") Long cedula_ciente) {
        return clienteService.obtenerPorCedula(cedula_ciente);
    }

    @DeleteMapping(path = "{cedula_ciente}")
    public String eliminarClientePorCedula(@PathVariable("cedula_ciente") Long cedula_ciente) {
        boolean eliminado = clienteService.eliminarCliente(cedula_ciente);

        if(eliminado) return "Cliente Eliminado";
        else return "Error Eliminando Cliente";
    }
}
