package com.mintic.appcomercio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Declara la clase como controlador

public class LogingController {

    @RequestMapping("/vistaloging") // Define la direccion del controlador
	public String listarclientes(Model model) {
	
		return "vistaLoging";
	}

    
}
