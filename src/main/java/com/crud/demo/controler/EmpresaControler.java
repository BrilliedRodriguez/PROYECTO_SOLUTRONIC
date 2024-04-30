 package com.crud.demo.controler;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crud.demo.modelo.Empresa;

import com.crud.demo.serviceInterface.IEmpresaService;

@Controller
@RequestMapping
public class EmpresaControler {
	
	@Autowired
	private IEmpresaService service;
	
	@GetMapping("/listarEmpresa")
	public String listar(Model model) {
		model.addAttribute("deportes", service.listar());
		return "indexD";
	}
	@GetMapping("/listarEmpresa/{id}")
	public String listarId(@PathVariable int id,Model model) {
		model.addAttribute("deporte", service.listarId(id));
		return "formD";
	}
	
	@GetMapping("/newEmpresa")
	public String nuevo(Model model) {
		model.addAttribute("empresa", new Empresa());
		return "formD";
	}
	
	 
	
	

	@PostMapping("/saveEmpresa")
	public String save(@Valid Empresa d, Model model) {
	    int id = service.save(d);
	    if (id == 0) {
	        return "formD";
	    }
	    return "redirect:/listarEmpresa";
	}

	
	@GetMapping("/editarEmpresa/{id}")
	public String editar(@PathVariable int id,Model model) {
		Optional<Empresa>deporte=service.listarId(id);
		model.addAttribute("deporte",deporte);
		return "formD";
	}
	

	@GetMapping("/inicio")
	public String inicio() {
		 
	 
		return "inicio";
	}
	 
	
	
	@GetMapping("/deleteEmpresa/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/listarEmpresa";
	}
}
