package com.mintic.appcomercio.repositories;

import java.util.List;
import java.util.Optional;

import com.mintic.appcomercio.models.ProveedoresModel;

public interface IProveedores {
	
	public List<ProveedoresModel> listar();
	
	public Optional<ProveedoresModel> listarId(int id);
	
	public int save(ProveedoresModel p);
	
	public void delete(int id);

}
