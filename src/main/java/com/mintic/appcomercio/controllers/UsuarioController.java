package com.mintic.appcomercio.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.mintic.appcomercio.services.UsuarioService;
import com.mintic.appcomercio.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Declara la clase como controlador
@RequestMapping("/usuarios") // Define la direccion del controlador
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public String agregar(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "formusuarios";
    }

    @GetMapping("/listar")
    public String listarusuarios(Model model) {
        ArrayList<UsuarioModel> usuarios = usuarioService.obtenerUsuarios();
        Long count = usuarioService.contarUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("cuenta", count);
        // return usuarioService.obtenerUsuarios();
        return "listarUsuarios";
    }

    // "application/x-www-form-urlencoded") // Update de datos
    // @RequestMapping(value = "/guardar", method = RequestMethod.PUT, consumes =
    // MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping(path = "/guardar")
    public String crearModificarUsuario(UsuarioModel usuario, RedirectAttributes model) {
        usuarioService.guardarUsuario(usuario);
        model.addFlashAttribute("mensaje", "Usuario " + usuario.cedula_usuario + " Guardado Exitosamente");
        model.addFlashAttribute("clase", "alert-success");
        return "redirect:/usuarios/listar";
    }

    @GetMapping(path = "/actualizar/{cedula_usuario}")
    public String obtenerPorCedula(@PathVariable Long cedula_usuario, Model model) {
        Optional<UsuarioModel> usuario = usuarioService.obtenerPorCedula(cedula_usuario);
        // return usuarioService.obtenerPorCedula(cedula_usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("bloqueado", "true");
        return "formusuarios";
    }

    @GetMapping(path = "/eliminar/{cedula_usuario}")
    public String eliminarUsuarioPorCedula(@PathVariable Long cedula_usuario, RedirectAttributes model) {
        boolean eliminado = usuarioService.eliminarUsuario(cedula_usuario);
        if (eliminado) {
            model.addFlashAttribute("mensaje", "Usuario Eliminado");
            model.addFlashAttribute("clase", "alert-danger");
            return "redirect:/usuarios/listar";
        } else {
            model.addFlashAttribute("mensaje", "Error Eliminando Usuario");
            model.addFlashAttribute("clase", "alert-warning");
            return "redirect:/usuarios/listar";
        }
    }
}