package com.crud.demo.controler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.demo.modelo.Empresa;
import com.crud.demo.modelo.Persona;
import com.crud.demo.serviceInterface.IEmpresaService;
import com.crud.demo.serviceInterface.IPersonaService;
import com.crud.demo.excepciones.PersonaNotFoundException;

@Controller
@RequestMapping
public class PersonaControler {
	
	@Autowired
	private IPersonaService service;
	@Autowired
    private IEmpresaService empresaService;
    
    @ModelAttribute("empresas")
    public List<Empresa> getEmpresas() {
        return empresaService.listar();
    }
    
	
	@GetMapping("/listarpersonas")
	public String listarpersonas(Model model) {
		model.addAttribute("personas", service.listar());
		return "index";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping("/save")

	public String save(
	        @Valid Persona p,BindingResult result,
	        Model model,
	        @RequestParam(value = "imagen", required = true) MultipartFile imagen , RedirectAttributes attribute
	) {
	
	    if (imagen != null && !imagen.isEmpty()) {
	        try {
	            // Establecer la ruta del directorio de imágenes
	            String rutaDirectorio = "src/main/resources/static/images/";
	            Path directorioImagenes = Paths.get(rutaDirectorio);

	            // Crear el directorio si no existe
	            if (!Files.exists(directorioImagenes)) {
	                Files.createDirectories(directorioImagenes);
	            }

	            // Obtener el nombre original del archivo
	            String nombreArchivo = imagen.getOriginalFilename();

	            // Crear la ruta completa del archivo
	            Path rutaCompleta = directorioImagenes.resolve(nombreArchivo);

	            // Guardar la imagen en el directorio
	            Files.write(rutaCompleta, imagen.getBytes());

	            // Establecer la ruta de la imagen como String en el objeto Persona
	            p.setImagen(nombreArchivo);

	        } catch (IOException e) {
	            // Manejar la excepción de manera apropiada, por ejemplo, registrándola o lanzándola
	            e.printStackTrace();
	         
	            attribute.addFlashAttribute("error", "Error al guardar la imagen.");
	            return "form";
	        }
	    }

	    // Guardar la persona en la base de datos
	    int id = service.save(p);
	    if (id == 0) {
	      
	        attribute.addFlashAttribute("error", "Error al guardar la persona.");
	        return "form";
	    }
	 attribute.addFlashAttribute("success", "Persona guardada con éxito."); 
	    return "redirect:/listarpersonas";
	}


	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model , RedirectAttributes attribute) {
	    Optional<Persona> persona = service.listarId(id);

	    if (persona.isPresent()) {
	        model.addAttribute("persona", persona.get());
	        model.addAttribute("imagenActual", persona.get().getImagen());
	        return "form";
	    } else {
	        // Lanza la excepción personalizada si no se encuentra la persona
	        throw new PersonaNotFoundException("La persona con el ID " + id + " no existe.");
	    }
	}

	 
	
	

	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable int id, Model model, RedirectAttributes attribute) {

	    try {
	        service.delete(id);
	        return "redirect:/listarpersonas";
	    } catch (Exception e) {
	        attribute.addFlashAttribute("error", "La persona con el ID " + id + " no existe. para eliminar el registro");
	        return "redirect:/listarpersonas";
	    }
	}

	
	
}
