package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.clinicaOdontologica.model.OdontologoDTO;
import com.clinicaOdontologica.clinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarOdontologo(OdontologoDTO odontologo){
        Odontologo newOdontologo = mapper.convertValue(odontologo, Odontologo.class);
        odontologoRepository.save(newOdontologo);
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologo){
        guardarOdontologo(odontologo);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) throws Exception {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologoEncontrado.isPresent())
            odontologoDTO = mapper.convertValue(odontologoEncontrado, OdontologoDTO.class);
        else
            throw new Exception("Odontologo no existe");
        return odontologoDTO;

    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologo) {
        guardarOdontologo(odontologo);
    }

    @Override
    public void borrarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> traerTodos() {
        List<Odontologo> allOdontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> allOdontologosDTO = new HashSet<>();
        for(Odontologo odontologo: allOdontologos)
            allOdontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return allOdontologosDTO;
    }

}
