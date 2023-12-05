package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.sistemaMatriculacion.repository.modelo.Propietario;
import com.uce.edu.sistemaMatriculacion.repository.modelo.Vehiculo;
import com.uce.edu.sistemaMatriculacion.service.IMatriculaService;
import com.uce.edu.sistemaMatriculacion.service.IPropietarioService;
import com.uce.edu.sistemaMatriculacion.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5JaApplication implements CommandLineRunner{
	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IMatriculaService matriculaService;
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Vehiculo ve = new Vehiculo();
		ve.setMarca("camaro");
		ve.setPlaca("1720");
		ve.setPrecio(new BigDecimal(200));
		ve.setTipo("pesado");
		
		this.vehiculoService.guardar(ve);
		System.out.println(this.vehiculoService.buscar("1720"));
		Propietario pro = new Propietario();
		pro.setApellido("Arteaga");
		pro.setCedula("172");
		pro.setGenero("masculino");
		pro.setNombre("jhon");
		
		this.propietarioService.guardar(pro);
		System.out.println(this.propietarioService.buscar("172"));
		pro.setApellido("chiles");
		this.propietarioService.actualizar(pro);
		System.out.println(this.propietarioService.buscar("172"));
		//this.matriculaService.realizar("1720","172");
		//System.out.println(this.matriculaService.buscar("jhon"));
	}

}
