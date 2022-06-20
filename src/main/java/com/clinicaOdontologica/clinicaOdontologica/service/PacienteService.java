package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.Paciente;
import com.clinicaOdontologica.clinicaOdontologica.model.PacienteDTO;
import com.clinicaOdontologica.clinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarPaciente(PacienteDTO paciente){
        Paciente newPaciente = mapper.convertValue(paciente, Paciente.class);
        pacienteRepository.save(newPaciente);
    }
    @Override
    public void crearPaciente(PacienteDTO paciente){
        guardarPaciente(paciente);
    }

    @Override
    public PacienteDTO leerPaciente(Long id){ //throws Exception {
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(pacienteEncontrado.isPresent())
            pacienteDTO = mapper.convertValue(pacienteEncontrado, PacienteDTO.class);
        /*else
            throw new Exception("Paciente no existe");*/
        return pacienteDTO;

    }

    @Override
    public void actualizarPaciente(PacienteDTO paciente) {
        guardarPaciente(paciente);
    }

    @Override
    public void borrarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        List<Paciente> allPacientes = pacienteRepository.findAll();
        Set<PacienteDTO> allPacientesDTO = new HashSet<PacienteDTO>();
        for(Paciente paciente: allPacientes)
            allPacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        return allPacientesDTO;
    }

}
