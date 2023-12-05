package com.uce.edu.sistemaMatriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {
	private static List<Propietario> base = new ArrayList<Propietario>();

	@Override
	public Propietario seleccionar(String cedula) {
		for (Propietario propietario : base) {
			if (propietario.getCedula().equals(cedula)) {
				Propietario pro = new Propietario();
				pro.setApellido(propietario.getApellido());
				pro.setCedula(propietario.getCedula());
				pro.setGenero(propietario.getGenero());
				pro.setNombre(propietario.getNombre());
				return propietario;
			}
		}
		return null;
	}

	@Override
	public void insertar(Propietario propietario) {
		base.add(propietario);

	}

	@Override
	public void eliminar(String cedula) {
		base.remove(this.seleccionar(cedula));

	}

	@Override
	public void actualizar(Propietario propietario) {
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);
		
	}

}
