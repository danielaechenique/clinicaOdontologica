package com.clinicaOdontologica.clinicaOdontologica.controller;

import com.clinicaOdontologica.clinicaOdontologica.model.OdontologoDTO;
import com.clinicaOdontologica.clinicaOdontologica.service.IOdontologoService;
import com.clinicaOdontologica.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> agregarOdontologo(@RequestBody OdontologoDTO odontologo) {
        odontologoService.crearOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO leerOdontologo(@PathVariable Long id) throws Exception {
        return odontologoService.leerOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologo) {
        odontologoService.actualizarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        odontologoService.borrarOdontologo(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/list")
    public Set<OdontologoDTO> listStudents() {
        return odontologoService.traerTodos();
    }
}
