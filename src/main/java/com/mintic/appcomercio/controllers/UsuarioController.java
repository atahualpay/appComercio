package com.mintic.appcomercio.controllers;

import java.util.List;
import java.util.Optional;

import com.mintic.appcomercio.repositories.UsuarioRepository;
import com.mintic.appcomercio.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository data;

    @GetMapping("/listarusuarios")
    public String listarusuarios(Model model) {
        List<UsuarioModel> usuarios = (List<UsuarioModel>) data.findAll();
        Long count = data.count();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("cuenta", count);
        return "listarUsuarios";
    }

    @GetMapping
    public String usuarios(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "usuarios";
    }

    @PostMapping
    public String guardarUsuario(@RequestBody UsuarioModel u) {
        data.save(u);
        return "redirect:/usuarios";
    }

    // PENDING: PENDIENTE VALIDAR CONSULTA POR CEDULA PARA EDICION
    @GetMapping(path = "{cedula}")
    public String editarUsuario(@PathVariable Long cedula, Model model) {
        Optional<UsuarioModel> usuario = data.findById(cedula);
        model.addAttribute("usuario", usuario);
        return "usuarios";
    }

    // @GetMapping(path = "{cedula}")
    // public Optional<UsuarioModel> editarUsuario(@PathVariable Long cedula, Model
    // model) {
    // Optional<UsuarioModel> usuario = data.findById(cedula);
    // model.addAttribute("usuario", usuario);
    // return usuario;
    // }

    @DeleteMapping(path = "{cedula}")
    public String borrarUsuario(@PathVariable Long cedula) {
        data.deleteById(cedula);
        return "redirect:/usuarios";
    }

}
