package com.uce.edu.sistemaMatriculacion.repository;


import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;

public interface IPropietarioRepository {
	
	public void insertar(Propietario propietario);
	public Propietario seleccionar(String cedula);
	public void eliminar(String cedula);
	public void actualizar(Propietario propietario);
}
