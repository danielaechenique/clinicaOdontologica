package com.clinicaOdontologica.clinicaOdontologica.model;

import com.clinicaOdontologica.clinicaOdontologica.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private Date fechaDeAlta;
    //private Domicilio domicilio;
}
