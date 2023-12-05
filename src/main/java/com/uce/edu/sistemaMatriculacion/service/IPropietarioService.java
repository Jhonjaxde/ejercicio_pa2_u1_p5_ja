package com.uce.edu.sistemaMatriculacion.service;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;

public interface IPropietarioService {
	public void guardar(Propietario propietario);
	public Propietario buscar(String cedula);
	public void eliminar(String cedula);
	public void actualizar(Propietario propietario);
}
