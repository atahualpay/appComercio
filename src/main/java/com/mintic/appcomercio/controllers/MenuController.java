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
/*@RequestMapping("/clientes") // Define la direccion del controlador*/
public class MenuController {

    @Autowired
    ClienteService menuService;

  
    
    @GetMapping("/menu")
	public String reportes(Model model) {
		return "menu";
	}
    
    
  
}
