package com.uce.edu.sistemaMatriculacion.repository;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	public Vehiculo seleccionar(String placa);
	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(String placa);
}
