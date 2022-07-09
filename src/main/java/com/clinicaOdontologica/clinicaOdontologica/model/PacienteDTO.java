package com.clinicaOdontologica.clinicaOdontologica.model;

import com.clinicaOdontologica.clinicaOdontologica.model.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {

    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private Date fechaDeAlta;
    //private Domicilio domicilio;
    private Set<Turno> turnos;
}
