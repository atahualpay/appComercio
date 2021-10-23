package com.mintic.appcomercio.controllers;

import java.util.List;
import java.util.Optional;

import com.mintic.appcomercio.models.ClienteModel;
import com.mintic.appcomercio.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // Declara la clase como controlador
@RequestMapping("/clientes") // Define la direccion del controlador
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public String principal(Model model) {
        model.addAttribute("cliente", new ClienteModel());
        return "formclientes";
    }

    @GetMapping("/listar")
    public String listarclientes(Model model) {
        List<ClienteModel> clientes = clienteService.obtenerClientes();
        model.addAttribute("clientes", clientes);
        return "listarClientes";
    }

    // @PostMapping // Update de datos
    // public ClienteModel crearModificarCliente(@RequestBody ClienteModel cliente)
    // {
    // return clienteService.guardarCliente(cliente);
    // }

//    @GetMapping(path = "{cedula_ciente}")
//    public String obtenerPorCedula(@PathVariable("cedula_ciente") int cedula_ciente, Model model) {
//        Optional<ClienteModel> cliente = clienteService.obtenerPorCedula(cedula_ciente);
//        model.addAttribute("cliente", cliente);
//        model.addAttribute("bloqueado", "true");
//        return "formclientes";
//    }

    // @DeleteMapping(path = "{cedula_ciente}")
    // public String eliminarClientePorCedula(@PathVariable("cedula_ciente") Long
    // cedula_ciente) {
    // boolean eliminado = clienteService.eliminarCliente(cedula_ciente);

    // if (eliminado)
    // return "Cliente Eliminado";
    // else
    // return "Error Eliminando Cliente";
    // }
}
