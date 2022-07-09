package com.clinicaOdontologica.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@Getter
@Setter
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String turno;
    //private LocalDateTime turno;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")//, nullable = false)
    private Paciente paciente;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id")//, nullable = false)
    private Odontologo odontologo;
}
