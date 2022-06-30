package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologo);
    OdontologoDTO leerOdontologo(Long id) throws Exception;
    void actualizarOdontologo(OdontologoDTO paciente);
    void borrarOdontologo(Long id);
    Set<OdontologoDTO> traerTodos();

}
