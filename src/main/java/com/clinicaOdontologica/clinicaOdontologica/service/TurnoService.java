package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.Turno;
import com.clinicaOdontologica.clinicaOdontologica.model.TurnoDTO;
import com.clinicaOdontologica.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarTurno(TurnoDTO turno){
        Turno newTurno = mapper.convertValue(turno, Turno.class);
        turnoRepository.save(newTurno);
    }
    @Override
    public void crearTurno(TurnoDTO turno) {
        guardarTurno(turno);
    }

    @Override
    public TurnoDTO leerTurno(Long id) throws Exception {
        Optional<Turno> turnoEncontrado = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turnoEncontrado.isPresent())
            turnoDTO = mapper.convertValue(turnoEncontrado, TurnoDTO.class);
        else
            throw new Exception("Turno no existe");
        return turnoDTO;
    }

    @Override
    public void actualizarTurno(TurnoDTO turno) {
        guardarTurno(turno);
    }

    @Override
    public void borrarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDTO> traerTodos() {
        List<Turno> allTurnos = turnoRepository.findAll();
        Set<TurnoDTO> allTurnosDTO = new HashSet<TurnoDTO>();
        for(Turno turno: allTurnos)
            allTurnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));

        return allTurnosDTO;
    }
}
