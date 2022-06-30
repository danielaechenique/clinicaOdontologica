package com.clinicaOdontologica.clinicaOdontologica;

import com.clinicaOdontologica.clinicaOdontologica.model.PacienteDTO;
import com.clinicaOdontologica.clinicaOdontologica.service.IPacienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private IPacienteService pacienteService;

    @BeforeAll
    @Test
    public void testCrearPaciente(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("daniela");
        pacienteDTO.setApellido("echenique");
        pacienteDTO.setDni("1234");
        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteDaniela = pacienteService.leerPaciente(1L);

        assertTrue(pacienteDaniela != null);
    }
}