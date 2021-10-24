package com.mintic.appcomercio.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import com.mintic.appcomercio.models.ProductosModel;
import com.mintic.appcomercio.services.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/listar")
    public String listarproductos(Model model) {
        ArrayList<ProductosModel> productos = productosService.obtenerProductos();
        Long count = productosService.contarUsuarios();
        model.addAttribute("productos", productos);
        model.addAttribute("cuenta", count);
        // return usuarioService.obtenerUsuarios();
        return "listarProductos";
    }

    @GetMapping(path = "/actualizar/{codigo_producto}")
    public String obtenerProducto(@PathVariable Long codigo_producto, Model model) {
        Optional<ProductosModel> producto = productosService.obtenerPorCodigo(codigo_producto);
        // return productosService.obtenerPorCodigo(codigo_producto);
        model.addAttribute("producto", producto);
        model.addAttribute("bloqueado", "true");
        return "formproductos";
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

    @PostMapping(path = "/guardar")
    public String crearModificarProducto(ProductosModel producto, RedirectAttributes model) {
        productosService.guardarProducto(producto);
        model.addFlashAttribute("mensaje", "Producto " + producto.codigo_producto + " Guardado Exitosamente");
        model.addFlashAttribute("clase", "alert-success");
        return "redirect:/productos/listar";
    }

    @GetMapping(path = "/eliminar/{codigo_producto}")
    public String eliminarUsuarioPorCodigo(@PathVariable Long codigo_producto, RedirectAttributes model) {
        boolean eliminado = productosService.eliminarProducto(codigo_producto);
        if (eliminado) {
            model.addFlashAttribute("mensaje", "Producto Eliminado");
            model.addFlashAttribute("clase", "alert-danger");
            return "redirect:/usuarios/listar";
        } else {
            model.addFlashAttribute("mensaje", "Error Eliminando Producto");
            model.addFlashAttribute("clase", "alert-warning");
            return "redirect:/productos/listar";
        }
    }

}
