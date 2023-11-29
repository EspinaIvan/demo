package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.Contacto;

@Service
public class OperacionesAgenda {

	private List<Contacto> listaContactos = new ArrayList<>();


	public void agregarContacto(Contacto contacto) {
		
		List<Contacto> listaTemp = obtenerContactos();
		contacto.setId(listaTemp.size()+1);
		listaContactos.add(contacto);
		System.out.println(contacto);
	}

	public List<Contacto> obtenerContactos() {
		return listaContactos;
		
	}
	
	 public Contacto obtenerContactoPorId(int id) {
		 
		 List<Contacto> listaTemp = obtenerContactos();
		 Contacto contacto  = listaTemp.get(id-1);
		 
	        return contacto;
	    }

	public void eliminarContacto(int id) {
		// TODO Auto-generated method stub
		List<Contacto> listaTemp = obtenerContactos();
		listaTemp.remove(id-1);
	}
}