package com.mintic.appcomercio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.appcomercio.models.ProveedoresModel;
import com.mintic.appcomercio.repositories.IProveedores;
import com.mintic.appcomercio.repositories.ProveedoresRepository;

@Service
public class ProveedoresService implements IProveedores{
	
	

	@Autowired
	ProveedoresRepository proveedoresRepository; 
	
	//int prov = (int) proveedoresmodel.getNitproveedor();
	
	@Override
	public List<ProveedoresModel> listar() {
		
		return (List<ProveedoresModel>)proveedoresRepository.findAll();
	}

	@Override	
	public Optional<ProveedoresModel> listarId(int nitproveedor) {
		
		return proveedoresRepository.findById(nitproveedor);
	}

	@Override
	public int save(ProveedoresModel p) {
		int res = 0;
		ProveedoresModel prov = proveedoresRepository.save(p);
		if(!prov.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int nitproveedor) {
		proveedoresRepository.deleteById(nitproveedor);
		
	}
	
	

}
