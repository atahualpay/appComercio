package com.mintic.appcomercio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mintic.appcomercio.models.ProveedoresModel;
import com.mintic.appcomercio.services.ProveedoresService;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {

	@Autowired
	public ProveedoresService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		List<ProveedoresModel> proveedores = service.listar();
		model.addAttribute("proveedores", proveedores);
		return "listar_proveedores";

	}

	@GetMapping
	public String agregar(Model model) {

		model.addAttribute("proveedor", new ProveedoresModel());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Validated ProveedoresModel p, Model model) {

		service.save(p);
		return "listar_proveedores";
	}

	@GetMapping("/editar/{nitproveedor}")
	public String editar(@PathVariable int nitproveedor, Model model) {

		Optional<ProveedoresModel> proveedor = service.listarId(nitproveedor);
		model.addAttribute("proveedor", proveedor);
		return "form";
	}

	@GetMapping("/eliminar/{nitproveedor}")
	public String delete(@PathVariable int nitproveedor, Model model) {

		service.delete(nitproveedor);
		return "listar_proveedores";
	}
}
