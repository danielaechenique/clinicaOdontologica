package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.DAO.ConfiguracionJDBC;
import com.clinicaOdontologica.clinicaOdontologica.DAO.IDao;
import com.clinicaOdontologica.clinicaOdontologica.DAO.impl.PacienteDaoH2;
import com.clinicaOdontologica.clinicaOdontologica.domain.Paciente;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    private static final Logger logger = Logger.getLogger(PacienteService.class);
    private IDao<Paciente> pacienteIdao = new PacienteDaoH2(new ConfiguracionJDBC());

    public PacienteService() throws Exception{
        try {
            pacienteIdao = new PacienteDaoH2(new ConfiguracionJDBC());
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public PacienteService(ConfiguracionJDBC configuracionJDBC) throws Exception {
        try {
            pacienteIdao = new PacienteDaoH2(configuracionJDBC);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    //Getters and setters
    /*public IDao<Paciente> getPacienteIdao() {
        return pacienteIdao;
    }
    public void setPacienteIdao(IDao<Paciente> pacienteIdao) {
        this.pacienteIdao = pacienteIdao;
    }*/

    // Metodos CRUD
    public String guardar(String apellido, String nombre, String domicilio, String dni, Date fechaDeAlta) {
        String respuesta = "No se pudo guadar el Paciente";
        try {
            Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);
            Paciente insertado = pacienteIdao.guardar(paciente);
            respuesta = "El Paciente " + insertado + " fue guardado con exito"; //revisar
            logger.info(respuesta);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public void eliminar(Long id){
        try {
            pacienteIdao.eliminar(id);
        } catch (SQLException e){
            logger.error(e.getMessage());
        }

    }

    public String buscar(Long id){
        String respuesta = "Paciente con ID: " + id + " no existe";
        try {
            Paciente paciente = pacienteIdao.buscarPorId(id);
            if(paciente != null){
                respuesta = "El Paciente con id:"+ id + " es " + paciente;
                logger.info(respuesta);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String buscarTodos() {
        String respuesta = "No hay pacientes";
        try {
            List<Paciente> pacientes = pacienteIdao.buscarTodos();
            if (pacientes.size() > 0) {
                respuesta = "Los odontologos son:\n";
                for (Paciente p : pacientes) {
                    respuesta += "\n" + p;
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }
}
