package com.clinicaOdontologica.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pacientes")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;

    private String apellido;
    private String nombre;
    private String dni;
    //private Date fechaDeAlta;
    // agregar relacion de domicilio
    //private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;
}
