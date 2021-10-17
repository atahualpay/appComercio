package com.mintic.appcomercio.controllers;

import java.io.IOException;

import com.mintic.appcomercio.services.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // Declara la clase como controlador
@RequestMapping("/productos") // Define la direccion del controlador*/
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public String productos(Model model) {
        // model.addAttribute("mensaje", "Hola Mundo");
        return "productos";
    }

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttr)
            throws IOException {
        if (file.isEmpty()) {
            redirectAttr.addFlashAttribute("mensaje", "Seleccionar un archivo CSV para cargar");
            redirectAttr.addFlashAttribute("clase", "alert-danger");
        } else {
            productosService.guardaProductos(file);
            redirectAttr.addFlashAttribute("mensaje", "Productos Cargados Exitosamente");
            redirectAttr.addFlashAttribute("clase", "alert-success");
        }
        return "redirect:/productos";
    }

}
