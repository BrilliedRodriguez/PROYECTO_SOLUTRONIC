package com.crud.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity /* anotacion */
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	/*se referencia que va a ser el
	 id de la tabla persona */
	private int id;
	 @Column(unique = true, nullable = false)
	    @NotBlank(message = "El nombre no puede estar vacío")
	private String name;

 
	 
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	public Empresa(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 
	 
	
	
}
