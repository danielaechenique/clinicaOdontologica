package com.clinicaOdontologica.clinicaOdontologica.controller;

import com.clinicaOdontologica.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.clinicaOdontologica.dto.OdontologoDTO;
import com.clinicaOdontologica.clinicaOdontologica.repository.impl.OdontologoListRepository;
import com.clinicaOdontologica.clinicaOdontologica.service.OdontologoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService = new OdontologoService(new OdontologoListRepository());

    @GetMapping
    public List<OdontologoDTO> buscarTodas(){
        return odontologoService.buscarTodas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        ResponseEntity response = null;
        if (odontologoService.eliminar(id)){
            response = ResponseEntity.status(HttpStatus.OK).build();
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo){
        odontologo.setId(Math.abs(new Random().nextInt()));
        return  ResponseEntity.ok(odontologoService.agregarOdontologo(odontologo));
    }
    @PutMapping
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscar(id));
    }

}
