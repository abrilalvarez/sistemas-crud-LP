package com.crud.sistemas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.crud.sistemas.modelo.Sistema;
import com.crud.sistemas.servicio.ServicioSistema;
import com.crud.sistemas.modelo.Oficina;
import com.crud.sistemas.servicio.ServicioOficina;

@Controller
public class ControladorSistema {

    @Autowired
    private ServicioSistema servicioSistema;

    @Autowired
    private ServicioOficina servicioOficina;

    // Listar todos los sistemas
    @GetMapping({"/sistemas", "/"})
    public String listarSistemas(Model model) {
        List<Sistema> sistemas = servicioSistema.listar();
        System.out.println("OK");
        int cantidadDeSistemas = sistemas.size();
        System.out.println("Cantidad de sistemas: " + cantidadDeSistemas);
        model.addAttribute("sistemas", sistemas);
        return "index";
    }

    // Mostrar formulario para crear un nuevo sistema
    @GetMapping("/sistemas/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        Sistema sistema = new Sistema();
        model.addAttribute("sistema", sistema);

        List <Oficina> listaOficinas = servicioOficina.listar(); 
        model.addAttribute("listaOficinas", listaOficinas);
        return "crear";
    }

    // Guardar sistema nuevo o editar existente
    @PostMapping("/sistemas")
    public String guardarSistema(@ModelAttribute("sistema") Sistema sistema) {
        System.out.println("Datos recibidos:");
        System.out.println(sistema.getNombre());
        System.out.println(sistema.getAutor());
        System.out.println(sistema.getDescripcion());
        System.out.println(sistema.getAnio());
        
        servicioSistema.save(sistema);
        return "redirect:/sistemas";
    }

    // Mostrar formulario para editar sistema
    @GetMapping("/sistemas/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") int id, Model model) {
        Sistema sistema = servicioSistema.findById(id);
        model.addAttribute("sistema", sistema);
        List <Oficina> listaOficinas = servicioOficina.listar();
        model.addAttribute("listaOficinas", listaOficinas);
        return "editar";
    }

    @PostMapping("/sistemas/{id}")
    public String actualizarSistema(@PathVariable int id, @ModelAttribute("sistema") Sistema sistema, Model modelo) {
		Sistema sistemaExistente = servicioSistema.findById(id);
		sistemaExistente.setId(id);
        sistemaExistente.setNombre(sistema.getNombre());
		sistemaExistente.setDescripcion(sistema.getDescripcion());
		sistemaExistente.setAutor(sistema.getAutor());
		sistemaExistente.setAnio(sistema.getAnio());
        sistemaExistente.setOficina(sistema.getOficina());
		servicioSistema.save(sistemaExistente);
		return "redirect:/sistemas";
	}

    // Eliminar sistema
    @GetMapping("/sistemas/eliminar/{id}")
    public String eliminarSistema(@PathVariable("id") int id) {
        servicioSistema.deleteById(id);
        return "redirect:/sistemas";
    }
}

