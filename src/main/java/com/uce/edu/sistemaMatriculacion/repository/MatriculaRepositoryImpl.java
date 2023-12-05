package com.uce.edu.sistemaMatriculacion.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Matricula;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Vehiculo;
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {
	private static List<Matricula> base = new ArrayList<Matricula>();

	@Override
	public Matricula seleccionar(String propietarioNombre) {
		for (Matricula matricula : base) {
			if (matricula.getPropietario().getNombre().equals(propietarioNombre)) {
				Matricula mat = new Matricula();
				mat.setFecha(matricula.getFecha());
				mat.setPropietario(matricula.getPropietario());
				mat.setValor(matricula.getValor());
				mat.setVehiculo(matricula.getVehiculo());
				return matricula;
			}
		}
		return null;
	}

	@Override
	public void insertar(Matricula matricula) {
		base.add(matricula);

	}

	@Override
	public void actualizar(Matricula matricula) {
		this.eliminar(matricula.getPropietario().getNombre());
		this.actualizar(matricula);
	}

	@Override
	public void eliminar(String propietarioNombre) {
		base.remove(this.seleccionar(propietarioNombre));

	}

}
