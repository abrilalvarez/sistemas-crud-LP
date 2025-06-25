package com.crud.sistemas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.sistemas.modelo.Oficina;
import com.crud.sistemas.repositorio.RepositorioOficina;

@Service
public class ServicioOficina implements ServicioOficinaInterface {

	@Autowired
	private RepositorioOficina repositorioOficina;
	
	@Override
	public List<Oficina> listar(){
		return repositorioOficina.findAll();
	}
}
