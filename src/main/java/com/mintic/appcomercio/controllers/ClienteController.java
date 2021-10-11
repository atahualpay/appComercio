package com.mintic.appcomercio.controllers;

import java.util.List;
import java.util.Optional;

import com.mintic.appcomercio.models.ClienteModel;
import com.mintic.appcomercio.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Declara la clase como controlador
@RequestMapping("/clientes") // Define la direccion del controlador
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listarclientes")
	public String listarclientes(Model model) {
		List<ClienteModel> clientes = clienteService.obtenerClientes();
		model.addAttribute("clientes", clientes);
		return "listarClientes";
	}
    
    @GetMapping("/proveedores")
	public String proveedores(Model model) {
		return "proveedores";
	}
    
    @GetMapping("/ventas")
	public String ventas(Model model) {
		return "ventas";
	}
    
    
    @GetMapping("/productos")
	public String productos(Model model) {
		return "productos";
	}
    
    @GetMapping("/reportes")
	public String reportes(Model model) {
		return "reportes";
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
