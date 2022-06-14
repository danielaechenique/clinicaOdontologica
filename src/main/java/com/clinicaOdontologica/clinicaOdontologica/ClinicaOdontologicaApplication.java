package com.clinicaOdontologica.clinicaOdontologica;

import com.clinicaOdontologica.clinicaOdontologica.DAO.ConfiguracionJDBC;
import com.clinicaOdontologica.clinicaOdontologica.service.OdontologoService;
import com.clinicaOdontologica.clinicaOdontologica.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	/*public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
	}*/

	/*private OdontologoService odontologoService;
	private PacienteService pacienteService;
	private static final Logger logger = Logger.getLogger(ClinicaOdontologicaApplication.class);

	public ClinicaOdontologicaApplication() {
		try {
			this.odontologoService = new OdontologoService(new ConfiguracionJDBC());
			this.pacienteService = new PacienteService(new ConfiguracionJDBC());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public ClinicaOdontologicaApplication(ConfiguracionJDBC configuracionJDBC) {
		try {
			this.odontologoService = new OdontologoService(configuracionJDBC);
			this.pacienteService = new PacienteService(configuracionJDBC);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public ClinicaOdontologicaApplication(OdontologoService odontologoService, PacienteService pacienteService) {
		this.odontologoService = odontologoService;
		this.pacienteService = pacienteService;
	}

	public String darDeAltaPaciente(String apellido, String nombre, String domicilio, String dni, Date fecha) {
		return pacienteService.guardar(apellido, nombre, domicilio, dni, fecha);
	}

	public String darDeAltaOdontologo(String nombre, String apellido, String matricula) {
		return odontologoService.guardar(nombre, apellido, matricula);
	}

	public String buscarPacientePorId(Long id) {
		return pacienteService.buscar(id);
	}

	public String buscarOdontologoPorId(Long id) {
		return odontologoService.buscar(id);
	}

	public String consultarTodos() {
		return pacienteService.buscarTodos() + "\n" + odontologoService.buscarTodos();
	}*/

}
