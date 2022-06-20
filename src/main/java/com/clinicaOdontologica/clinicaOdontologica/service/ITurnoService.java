package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.*;

import java.util.Collection;
import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turno);
    TurnoDTO leerTurno(Long id) throws Exception;
    void actualizarTurno(TurnoDTO turno);
    void borrarTurno(Long id);
    Collection<TurnoDTO> getAll();
}
