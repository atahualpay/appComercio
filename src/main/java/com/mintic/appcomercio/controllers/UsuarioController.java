package com.mintic.appcomercio.controllers;

import java.util.List;
import java.util.Optional;

import com.mintic.appcomercio.services.UsuarioService;
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

@Controller // Declara la clase como controlador
@RequestMapping("/usuarios") // Define la direccion del controlador
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listarusuarios")

	  public String listarusuarios(Model model) {
		  List<UsuarioModel> usuarios = usuarioService.obtenerUsuarios();
      Long count = data.count();
		  model.addAttribute("usuarios", usuarios);
      model.addAttribute("cuenta", count);
		  return "listarUsuarios";
	  }
    
    @GetMapping
    public String usuarios(Model model) {
      model.addAttribute("usuario", new UsuarioModel());
    return "usuarios";  
  
    @PostMapping    //Update de datos
    public UsuarioModel crearModificarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "{cedula_usuario}")
    public Optional<UsuarioModel> obtenerPorCedula(@PathVariable("cedula_usuario") Long cedula_usuario) {
        return usuarioService.obtenerPorCedula(cedula_usuario);
    }

    @DeleteMapping(path = "{cedula_usuario}")
    public String eliminarUsuarioPorCedula(@PathVariable("cedula_usuario") Long cedula_usuario) {
        boolean eliminado = usuarioService.eliminarUsuario(cedula_usuario);

        if(eliminado) return "Cliente Eliminado";
        else return "Error Eliminando Cliente";
    }
}