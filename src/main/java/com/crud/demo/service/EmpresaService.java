package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.modelo.Empresa;
import com.crud.demo.modeloDAO.IEmpresa;
import com.crud.demo.serviceInterface.IEmpresaService;

@Service
public class EmpresaService implements IEmpresaService {

	@Autowired
	private IEmpresa dao;
	
	@Override
	public List<Empresa> listar() {		
		return (List<Empresa>) dao.findAll();
	}

	@Override
	public Optional<Empresa> listarId(int id) {		
		return dao.findById(id);
	}

	@Override
 
	public int save(Empresa d) {
	    try {
	        dao.save(d);
	        return 1;
	    } catch (Exception e) {
	        // Manejar la excepción según tus necesidades
	        e.printStackTrace();
	        return 0;
	    }
	}


	@Override
	public void delete(int id) {
		dao.deleteById(id);
		
	}

}
