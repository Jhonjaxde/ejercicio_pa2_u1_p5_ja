package com.uce.edu.sistemaMatriculacion.service;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public Vehiculo buscar(String placa);
	public void guardar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(String placa);
}
