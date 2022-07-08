package com.clinicaOdontologica.clinicaOdontologica.controller;


import com.clinicaOdontologica.clinicaOdontologica.model.TurnoDTO;

import com.clinicaOdontologica.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> agregarTurno(@RequestBody TurnoDTO turno) {
        turnoService.crearTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
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
