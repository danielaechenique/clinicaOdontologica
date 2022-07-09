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
    public TurnoDTO crearTurno(TurnoDTO turno) {
        guardarTurno(turno);
        /*turno.getOdontologo().setId(2L);
        turno.getPaciente().setId(3L);*/
        return turno;
    }

    @Override
    public TurnoDTO leerTurno(Long id) throws Exception {
        Optional<Turno> turnoEncontrado = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turnoEncontrado.isPresent())
            turnoDTO = mapper.convertValue(turnoEncontrado, TurnoDTO.class);
        else
            throw new Exception("El turno no existe");
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
        List<Turno> todosLosTurnos = turnoRepository.findAll();
        Set<TurnoDTO> todosLosTurnosDTO = new HashSet<TurnoDTO>();
        for(Turno turno: todosLosTurnos)
            todosLosTurnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));

        return todosLosTurnosDTO;
    }
}
