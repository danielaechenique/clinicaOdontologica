package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.*;

import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO paciente);
    PacienteDTO leerPaciente(Long id); //throws Exception;
    void actualizarPaciente(PacienteDTO paciente);
    void borrarPaciente(Long id);
    Set<PacienteDTO> traerTodos();
}
