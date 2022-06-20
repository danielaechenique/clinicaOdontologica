package com.clinicaOdontologica.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

}
