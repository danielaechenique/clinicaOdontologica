package com.clinicaOdontologica.clinicaOdontologica.service;


import com.clinicaOdontologica.clinicaOdontologica.DAO.ConfiguracionJDBC;
import com.clinicaOdontologica.clinicaOdontologica.DAO.IDao;
import com.clinicaOdontologica.clinicaOdontologica.DAO.impl.OdontologoDaoH2;
import com.clinicaOdontologica.clinicaOdontologica.domain.Odontologo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OdontologoService {

    private List<Odontologo> odontologos = new ArrayList<>();

    public OdontologoService(){
        odontologos.add(new Odontologo(111, "Pepe", "Pepardo", "12AB"));
        odontologos.add(new Odontologo(222, "Pepa", "Peparda", "34AB"));
        odontologos.add(new Odontologo(333, "Pepo", "Pepardo", "56AB"));
    }

    public List<Odontologo> getAll(){
        return odontologos;
    }

    public Odontologo getOdontologoById(String email){
        for (Odontologo paciente : odontologos) {
            /*if (paciente.getId().equals(email)) {
                return paciente;
            }*/
        }
        return null;
    }

    /*private static final Logger logger = Logger.getLogger(OdontologoService.class);
    private IDao<Odontologo> odontologoIdao = new OdontologoDaoH2(new ConfiguracionJDBC());

    public OdontologoService() throws Exception{
        try {
            odontologoIdao = new OdontologoDaoH2(new ConfiguracionJDBC());
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public OdontologoService(ConfiguracionJDBC configuracionJDBC) throws Exception {
        try {
            odontologoIdao = new OdontologoDaoH2(configuracionJDBC);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    //Getters and setters
    *//*public IDao<Odontologo> getOdontologoIdao() {
        return odontologoIdao;
    }
    public void setOdontologoIdao(IDao<Odontologo> odontologoIdao) {
        this.odontologoIdao = odontologoIdao;
    }*//*

    // Metodos CRUD
    public String guardar(String nombre, String apellido, String matricula) {
        String respuesta = "No se pudo guadar el odontologo";
        try {
            Odontologo odontologo = new Odontologo(nombre, apellido, matricula);
            Odontologo insertado = odontologoIdao.guardar(odontologo);
            respuesta = "El odontologo " + insertado + " fue guardado con exito"; //revisar
            logger.info(respuesta);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public void eliminar(Long id){
        try {
            odontologoIdao.eliminar(id);
        } catch (SQLException e){
            logger.error(e.getMessage());
        }

    }

    public String buscar(Long id){
        String respuesta = "Odontologo con ID: " + id + " no existe";
        try {
            Odontologo odontologo = odontologoIdao.buscarPorId(id);
            if(odontologo != null){
                respuesta = "El odontologo con id:"+ id + " es " + odontologo;
                logger.info(respuesta);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return respuesta;
    }

    public String buscarTodos() {
        String respuesta = "No hay odontologos";
        try {
            List<Odontologo> odontologos = odontologoIdao.buscarTodos();
            if (odontologos.size() > 0) {
                respuesta = "Los odontologos son:\n";
                for (Odontologo o : odontologos) {
                    respuesta += "\n" + o;
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return respuesta;
    }*/

}
