package com.uce.edu.sistemaMatriculacion.service;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Matricula;

public interface IMatriculaService {
	public Matricula buscar(String propietarioNombre);
	public void guardar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public void eliminar(String propietarioNombre);
	public void realizar(String cedula, String placa);
}
