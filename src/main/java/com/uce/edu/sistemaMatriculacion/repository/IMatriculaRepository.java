package com.uce.edu.sistemaMatriculacion.repository;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Matricula;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;

public interface IMatriculaRepository {
	public Matricula seleccionar(String propietarioNombre);
	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public void eliminar(String propietarioNombre);
}
