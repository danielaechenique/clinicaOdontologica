package com.clinicaOdontologica.clinicaOdontologica.controller;


import com.clinicaOdontologica.clinicaOdontologica.model.*;

import com.clinicaOdontologica.clinicaOdontologica.service.IOdontologoService;
import com.clinicaOdontologica.clinicaOdontologica.service.IPacienteService;
import com.clinicaOdontologica.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;
    @Autowired
    IOdontologoService odontologoService;
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> agregarTurno(@RequestBody TurnoDTO turno) {
        //turnoService.crearTurno(turno);
        //return ResponseEntity.ok(HttpStatus.OK);
        ResponseEntity<?> response;

        PacienteDTO pacienteDTO = pacienteService.leerPaciente(turno.getPaciente().getId());
        OdontologoDTO odontologoDTO = odontologoService.leerOdontologo(turno.getOdontologo().getId());

        if (pacienteDTO!=null && odontologoDTO!=null) {
            response = ResponseEntity.ok(turnoService.crearTurno(turno));
        }
        else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
        /*ResponseEntity<?> response;
        response = ResponseEntity.ok(turnoService.crearTurno(turno));
        return response;*/
    }


    @GetMapping("/{id}")
    public TurnoDTO leerTurno(@PathVariable Long id) throws Exception {
        return turnoService.leerTurno(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDTO turno) {
        turnoService.actualizarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        turnoService.borrarTurno(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Turno eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<TurnoDTO> listaTurnos() {
        return turnoService.traerTodos();
    }
}
