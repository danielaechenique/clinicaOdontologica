package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.model.Domicilio;
import com.clinicaOdontologica.clinicaOdontologica.model.DomicilioDTO;
import com.clinicaOdontologica.clinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DomicilioService {
    private final IDomicilioRepository domicilioRepository;

    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public DomicilioDTO crearDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return domicilioDTO;
    }

    public DomicilioDTO modificarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        return domicilioDTO;
    }

    public DomicilioDTO buscarDomicilioPorId(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    public Set<DomicilioDTO> traerTodosLosDomicilios() {
        List<Domicilio> domicilioList = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOList = new HashSet<>();

        for (Domicilio domicilio : domicilioList) {
            domicilioDTOList.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }

        return domicilioDTOList;
    }

    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }
}
