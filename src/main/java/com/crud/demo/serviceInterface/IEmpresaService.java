package com.crud.demo.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.crud.demo.modelo.Empresa;

public interface IEmpresaService {
	public List<Empresa> listar();

	public Optional<Empresa> listarId(int id);

	public int save(Empresa d);

	public void delete(int id);
}
