package com.uce.edu.sistemaMatriculacion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.sistemaMatriculacion.repository.IMatriculaRepository;
import com.uce.edu.sistemaMatriculacion.repository.IPropietarioRepository;
import com.uce.edu.sistemaMatriculacion.repository.IVehiculoRepository;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Matricula;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Vehiculo;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
	@Autowired
	private IMatriculaRepository matriculaRepository;
	@Autowired
	private IVehiculoService vehiculo;
	@Autowired
	private IPropietarioService propietario;
	@Override
	public Matricula buscar(String propietarioNombre) {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionar(propietarioNombre);
	}

	@Override
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	public void eliminar(String propietarioNombre) {
		// TODO Auto-generated method stub
		this.matriculaRepository.eliminar(propietarioNombre);
	}

	@Override
	public void realizar(String cedula, String placa) {
		Vehiculo veh = this.vehiculo.buscar(placa);
		Propietario pro = this.propietario.buscar(cedula);
		Matricula mat = new Matricula();
		BigDecimal valorMatricula = mat.getValor();
		if(veh.getTipo().equals("pesado")) {
			valorMatricula = veh.getPrecio().multiply(new BigDecimal(0.25));
			mat.setValor(valorMatricula);
			this.actualizar(mat);
		}
		else if(veh.getTipo().equals("liviano")) {
			 valorMatricula = veh.getPrecio().multiply(new BigDecimal(0.20));
			mat.setValor(valorMatricula);
			this.actualizar(mat);
			
		}
		if(mat.getValor().compareTo(new BigDecimal(2200))>0) {
			BigDecimal descuento= valorMatricula.multiply(new BigDecimal(0.05));
			valorMatricula = valorMatricula.subtract(descuento);
			mat.setValor(valorMatricula);
			//this.actualizar(mat);
		}	
		mat.setPropietario(pro);
		mat.setVehiculo(veh);
		mat.setValor(valorMatricula);
		mat.setFecha(LocalDateTime.now());
		this.matriculaRepository.actualizar(mat);
		
		

	}

}
