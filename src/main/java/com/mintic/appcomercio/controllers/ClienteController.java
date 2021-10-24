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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Long count = clienteService.contarClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cuenta", count);
        return "listarClientes";
    }

    @PostMapping(path = "/guardar")
    public String crearModificarUsuario(ClienteModel cliente, RedirectAttributes model) {
        clienteService.guardarCliente(cliente);
        model.addFlashAttribute("mensaje", "Cliente " + cliente.cedula_cliente + " Guardado Exitosamente");
        model.addFlashAttribute("clase", "alert-success");
        return "redirect:/clientes/listar";
    }

    @GetMapping(path = "/actualizar/{cedula_cliente}")
    public String obtenerPorCedula(@PathVariable Long cedula_cliente, Model model) {
        Optional<ClienteModel> cliente = clienteService.obtenerPorCedula(cedula_cliente);
        // return clienteService.obtenerPorCedula(cedula_cliente);
        model.addAttribute("cliente", cliente);
        model.addAttribute("bloqueado", "true");
        return "formclientes";
    }

    @GetMapping(path = "/eliminar/{cedula_cliente}")
    public String eliminarUsuarioPorCedula(@PathVariable Long cedula_cliente, RedirectAttributes model) {
        boolean eliminado = clienteService.eliminarCliente(cedula_cliente);
        if (eliminado) {
            model.addFlashAttribute("mensaje", "Cliente Eliminado");
            model.addFlashAttribute("clase", "alert-danger");
            return "redirect:/clientes/listar";
        } else {
            model.addFlashAttribute("mensaje", "Error Eliminando Cliente");
            model.addFlashAttribute("clase", "alert-warning");
            return "redirect:/clientes/listar";
        }
    }
}
