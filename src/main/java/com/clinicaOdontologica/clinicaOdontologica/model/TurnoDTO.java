package com.clinicaOdontologica.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private String turno;
    //private LocalDateTime turno;
    //private Paciente paciente;
    //private Odontologo odontologo;
}
