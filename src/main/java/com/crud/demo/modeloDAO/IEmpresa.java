package com.crud.demo.modeloDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.modelo.Empresa;

@Repository
public interface IEmpresa extends CrudRepository<Empresa, Integer>{

}
