package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.example.demo.DAO.Contacto;
import com.example.demo.servicio.OperacionesAgenda;

@Controller("/")
public class Controlador {

	@Autowired
	private OperacionesAgenda opeAgenda;

	@GetMapping("/")
	public String controladorInicio(Model modelo) {

		Contacto contacto = new Contacto();
		modelo.addAttribute("contacto", contacto);
		List<Contacto> listaContactos = opeAgenda.obtenerContactos();
		modelo.addAttribute("listaContacto", listaContactos);

		return "index";

	}

	@PostMapping("agregarAgenda")

	public String agergarAgenda(@ModelAttribute("contacto") Contacto contacto) {

		opeAgenda.agregarContacto(contacto);
		
		return "redirect:/";

	}

	@GetMapping("/editarContacto/{id}")
	public String editarContacto(@PathVariable int id, Model modelo) {
		Contacto contacto = opeAgenda.obtenerContactoPorId(id);
		modelo.addAttribute("contacto", contacto);
		List<Contacto> listaContactos = opeAgenda.obtenerContactos();
		modelo.addAttribute("listaContacto", listaContactos);
		return "index";
	}

	@GetMapping("/eliminarContacto/{id}")
	public String eliminarContacto(@PathVariable int id) {
		opeAgenda.eliminarContacto(id);

		return "redirect:/";
	}
}
