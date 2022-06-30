package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.*;

import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turno);
    TurnoDTO leerTurno(Long id) throws Exception;
    void actualizarTurno(TurnoDTO turno);
    void borrarTurno(Long id);
    Set<TurnoDTO> traerTodos();
}
