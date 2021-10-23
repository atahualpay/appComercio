package com.mintic.appcomercio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Declara la clase como controlador
@RequestMapping("/") // Define la direccion del controlador */
public class MenuController {

    @GetMapping
    public String showmenu() {
        return "menu";
    }

}
