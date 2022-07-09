package com.clinicaOdontologica.clinicaOdontologica.controller;

import com.clinicaOdontologica.clinicaOdontologica.model.PacienteDTO;
import com.clinicaOdontologica.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDTO paciente) {
        pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO leerPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.leerPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO paciente) {
        pacienteService.actualizarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        pacienteService.borrarPaciente(id);
        response = ResponseEntity.status(HttpStatus.OK).body("El paciente fue eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<PacienteDTO> listarPacientes() {
        return pacienteService.traerTodos();
    }


}
