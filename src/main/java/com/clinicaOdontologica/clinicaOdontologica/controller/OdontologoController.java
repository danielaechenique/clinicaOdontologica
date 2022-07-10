package com.clinicaOdontologica.clinicaOdontologica.controller;

import com.clinicaOdontologica.clinicaOdontologica.model.OdontologoDTO;
import com.clinicaOdontologica.clinicaOdontologica.service.IOdontologoService;
import org.apache.velocity.exception.ResourceNotFoundException;
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
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {

        ResponseEntity<String> response = null;
        odontologoService.borrarOdontologo(id);
        //response = ResponseEntity.status(HttpStatus.OK).body("El odontologo fue eliminado");
        return ResponseEntity.ok("El odontologo fue eliminado");
    }

    @GetMapping("/list")
    public Set<OdontologoDTO> listarOdontologos() {
        return odontologoService.traerTodos();
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
