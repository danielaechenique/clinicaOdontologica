package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.Odontologo;
import com.clinicaOdontologica.clinicaOdontologica.dto.OdontologoDTO;
import com.clinicaOdontologica.clinicaOdontologica.repository.IRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class OdontologoService {
    private IRepository<Odontologo> odontologoRepository;

    public OdontologoService(IRepository<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<OdontologoDTO> buscarTodas(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(odontologoRepository.buscarTodas(),new TypeReference<List<OdontologoDTO>>(){});

    }
    public Odontologo agregarOdontologo(Odontologo odontologo) {
        return this.odontologoRepository.agregar(odontologo);
    }

    public Odontologo buscar(Long id){
        return odontologoRepository.buscar(id);
    }

    public Boolean eliminar(Long id){
        return odontologoRepository.eliminar(id);
    }

    public Odontologo actualizar(Odontologo odontologo){
        return odontologoRepository.actualizar(odontologo);
    }

}
